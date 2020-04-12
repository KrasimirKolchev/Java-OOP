package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.Iterator;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        this.mainPlayerAttacksCivilPlayers(mainPlayer, civilPlayers);

        this.civilPlayerAttacksMainPlayer(mainPlayer, civilPlayers);
    }

    private void civilPlayerAttacksMainPlayer(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            if (!mainPlayer.isAlive()) {
                break;
            }

            if (civilPlayer.isAlive()) {
                this.shootEnemy(civilPlayer, mainPlayer);
            }
        }
    }

    private void mainPlayerAttacksCivilPlayers(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            this.shootEnemy(mainPlayer, civilPlayer);
        }
    }

    private void shootEnemy(Player attacker, Player victim) {
        Iterator<Gun> guns = attacker.getGunRepository().getModels().iterator();

        while (guns.hasNext() && victim.isAlive()) {
            Gun currentGun = guns.next();

            while (currentGun.canFire() && victim.isAlive()) {
                int damage = currentGun.fire();
                victim.takeLifePoints(damage);
            }
        }
    }
}
