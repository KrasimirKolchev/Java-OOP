package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;
import static common.ConstantMessages.*;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.isDead = false;
    }

    private void setUsername(String username) {
        if (username.trim().isEmpty() || username == null) {
            throw new IllegalArgumentException(PLAYER_USERNAME_NOT_NULL);
        }
        this.username = username;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException(PLAYER_HP_LESS_THAN_ZERO);
        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException(DAMAGE_POINTS_LESS_THAN_ZERO);
        }

        this.health -= damagePoints;

        if (this.health < 0) {
            this.health = 0;
            this.isDead = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PLAYER_REPORT_INFO
                , this.getUsername(), this.getHealth(), this.getCardRepository().getCount()));
        sb.append(System.lineSeparator());

        this.getCardRepository().getCards().forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));
        sb.append(DEFAULT_REPORT_SEPARATOR);

        return sb.toString().trim();
    }
}
