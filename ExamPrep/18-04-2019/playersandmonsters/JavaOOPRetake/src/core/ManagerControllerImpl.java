package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.*;
import models.cards.interfaces.Card;
import models.players.*;
import models.players.interfaces.Player;
import repositories.*;
import repositories.interfaces.*;


public class ManagerControllerImpl implements ManagerController {
    private static final String TRAP_CARD = "Trap";
    private static final String MAGIC_CARD = "Magic";

    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;

        if (Beginner.class.getSimpleName().equals(type)) {
            player = new Beginner(new CardRepositoryImpl(), username);
        } else if (Advanced.class.getSimpleName().equals(type)) {
            player = new Advanced(new CardRepositoryImpl(), username);
        }

        this.playerRepository.add(player);

        String msg = String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
        return msg;

    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;

        if (MAGIC_CARD.equals(type)) {
            card = new MagicCard(name);
        } else if (TRAP_CARD.equals(type)) {
            card = new TrapCard(name);
        }

        this.cardRepository.add(card);
        String msg = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);

        return msg;
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = this.playerRepository.find(username);
        Card card = this.cardRepository.find(cardName);

        player.getCardRepository().add(card);
        String msg = String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);

        return msg;
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attackPlayer = this.playerRepository.find(attackUser);
        Player enemyPlayer = this.playerRepository.find(enemyUser);

        this.battlefield.fight(attackPlayer, enemyPlayer);

        String msg = String.format(ConstantMessages.FIGHT_INFO, attackPlayer.getHealth(), enemyPlayer.getHealth());

        return msg;
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(player.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
