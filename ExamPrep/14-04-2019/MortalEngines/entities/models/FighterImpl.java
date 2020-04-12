package entities.models;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200.0;
    private static final boolean DEFAULT_MODE = true;
    private static final double ATTACK_POINTS_MODIFIER = 50.0;
    private static final double DEFENSE_POINTS_MODIFIER = 25.0;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.aggressiveMode = DEFAULT_MODE;
    }

    @Override
    public double getAttackPoints() {
        double points = super.getAttackPoints();

        if (getAggressiveMode()) {
            points += ATTACK_POINTS_MODIFIER;
        } else {
            points -= ATTACK_POINTS_MODIFIER;
        }
        return points;
    }

    @Override
    public double getDefensePoints() {
        double points = super.getAttackPoints();

        if (getAggressiveMode()) {
            points -= DEFENSE_POINTS_MODIFIER;
        } else {
            points += DEFENSE_POINTS_MODIFIER;
        }
        return points;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.aggressiveMode = false;
        } else {
            this.aggressiveMode = true;
        }
    }
}
