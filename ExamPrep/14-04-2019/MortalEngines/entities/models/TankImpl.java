package entities.models;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100.0;
    private static final boolean DEFAULT_MODE = true;
    private static final double ATTACK_POINTS_MODIFIER = 40.0;
    private static final double DEFENSE_POINTS_MODIFIER = 30.0;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.defenseMode = DEFAULT_MODE;
    }

    @Override
    public double getAttackPoints() {
        double points = super.getAttackPoints();

        if (getDefenseMode()) {
            points -= ATTACK_POINTS_MODIFIER;
        } else {
            points += ATTACK_POINTS_MODIFIER;
        }
        return points;
    }

    @Override
    public double getDefensePoints() {
        double points = super.getAttackPoints();

        if (getDefenseMode()) {
            points += DEFENSE_POINTS_MODIFIER;
        } else {
            points -= DEFENSE_POINTS_MODIFIER;
        }
        return points;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.defenseMode = false;
        } else {
            this.defenseMode = true;
        }
    }
}
