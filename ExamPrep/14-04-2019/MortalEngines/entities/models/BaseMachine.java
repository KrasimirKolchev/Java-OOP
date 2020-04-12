package entities.models;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {

    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    public BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.setPilot(pilot);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {

    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {

    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return null;
    }

    @Override
    public void attack(String target) {

    }
}
