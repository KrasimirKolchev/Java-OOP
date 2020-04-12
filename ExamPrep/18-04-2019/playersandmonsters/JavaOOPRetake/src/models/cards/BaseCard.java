package models.cards;

import models.cards.interfaces.Card;
import static common.ConstantMessages.*;

public abstract class BaseCard implements Card {
    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setDamagePoints(damagePoints);
        this.setHealthPoints(healthPoints);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new IllegalArgumentException(CARD_NAME_NOT_NULL);
        }
        this.name = name;
    }

    private void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException(CARD_HP_LESS_THAN_ZERO);
        }
        this.healthPoints = healthPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException(CARD_POINTS_LESS_THAN_ZERO);
        }
        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public String toString() {
        String msg = String.format(CARD_REPORT_INFO, this.getName(), this.getDamagePoints());
        return msg;
    }
}
