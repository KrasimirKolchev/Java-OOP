package viceCity.core.interfaces;

import viceCity.common.ConstantMessages;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> civilPlayers;
    private Deque<Gun> gunRepository;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        String msg = "";

        Gun gun = createGun(type, name);

        if (gun != null) {
            this.gunRepository.offer(gun);
            msg = String.format(GUN_ADDED, name, type);
        } else {
            msg = GUN_TYPE_INVALID;
        }

        return msg;
    }

    private Gun createGun(String type, String name) {
        Gun gun = null;

        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }
        return gun;
    }

    private boolean hasGuns() {
        return !this.gunRepository.isEmpty();
    }

    @Override
    public String addGunToPlayer(String name) {

        if (!this.hasGuns()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun;
        if (name.equals("Vercetti")) {
            gun = this.gunRepository.poll();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        }

        Player player = this.getPlayerByName(name);
        String msg;

        if (player != null) {
            gun = this.gunRepository.poll();
            player.getGunRepository().add(gun);
            msg = String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
        } else {
            msg = CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        return msg;
    }

    private Player getPlayerByName(String name) {
        Player player = null;
        for (Player currentPlayer : this.getAllCivilPlayers()) {
            if (currentPlayer.getName().equals(name)) {
                player = currentPlayer;
                break;
            }
        }
        return player;
    }

    private Collection<Player> getAllCivilPlayers() {
        return Collections.unmodifiableCollection(this.civilPlayers);
    }

    @Override
    public String fight() {
        int initialMainPlayerLifePoints = this.mainPlayer.getLifePoints();
        int initialCivilPlayersLifePoints = this.calculateLifePoints();

        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);

        String msg = this.actionReport(initialMainPlayerLifePoints, initialCivilPlayersLifePoints);
        return msg;
    }

    private String actionReport(int initialMainPlayerLifePoints, int initialCivilPlayersLifePoints) {
        int afterFightMPLifePoints = this.mainPlayer.getLifePoints();
        int afterFightCPLifePoints = this.calculateLifePoints();

        boolean noFightHappened = initialMainPlayerLifePoints == afterFightMPLifePoints
                && initialCivilPlayersLifePoints == afterFightCPLifePoints;

        if (noFightHappened) {
            return FIGHT_HOT_HAPPENED;
        } else {
            return this.getFightStatistics();
        }
    }

    private String getFightStatistics() {
        int allCiviliansCount = this.getCivilianPlayersCount();
        this.removeDeadCivilians();
        int killedCivilians = allCiviliansCount - this.getCivilianPlayersCount();

        StringBuilder report = new StringBuilder();
        report
                .append(ConstantMessages.FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedCivilians))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.size()));

        return report.toString();
    }

    private int getCivilianPlayersCount () {
        return this.civilPlayers.size();
    }

    private void removeDeadCivilians() {
        this.civilPlayers.removeIf(player -> !player.isAlive());
    }

    private int calculateLifePoints() {
        int lifePoints = 0;

        for (Player civilian : this.getAllCivilPlayers()) {
            lifePoints += civilian.getLifePoints();
        }
        return lifePoints;
    }
}
