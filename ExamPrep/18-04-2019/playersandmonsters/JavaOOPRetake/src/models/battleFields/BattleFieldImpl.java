package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        fightPreparation(attackPlayer);
        fightPreparation(enemyPlayer);

        healthPointsBonusFromDeck(attackPlayer);
        healthPointsBonusFromDeck(enemyPlayer);

        startBattle(attackPlayer, enemyPlayer);
    }

    private void startBattle(Player attackPlayer, Player enemyPlayer) {

        while (true) {
            int attackPlayerDamage = attackPlayer.getCardRepository().getCards().stream()
                    .mapToInt(Card::getDamagePoints).sum();
            enemyPlayer.takeDamage(attackPlayerDamage);

            if (enemyPlayer.isDead()) {
                return;
            }

            int enemyPlayerDamage = enemyPlayer.getCardRepository().getCards().stream()
                    .mapToInt(Card::getDamagePoints).sum();
            attackPlayer.takeDamage(enemyPlayerDamage);

            if (attackPlayer.isDead()) {
                return;
            }
        }

    }

    private void healthPointsBonusFromDeck(Player player) {
        int bonusHealthPoints = player.getCardRepository().getCards().stream()
                .mapToInt(Card::getHealthPoints).sum();
         player.setHealth(player.getHealth() + bonusHealthPoints);
    }

    private void fightPreparation(Player player) {
        if (!Beginner.class.getSimpleName().equals(player.getClass().getSimpleName())) {
            return;
        } else {
            player.setHealth(player.getHealth() + 40);
            player.getCardRepository().getCards()
                    .forEach(c -> c.setDamagePoints(c.getDamagePoints() + 30));
        }
    }
}
