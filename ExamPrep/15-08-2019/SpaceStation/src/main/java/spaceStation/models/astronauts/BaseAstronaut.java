package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Bag;
import spaceStation.models.bags.Backpack;

import static spaceStation.common.ConstantMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private double OXYGEN_VALUE_TO_DECREASE = 10;

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() >= OXYGEN_VALUE_TO_DECREASE;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - OXYGEN_VALUE_TO_DECREASE);
        if (this.getOxygen() < 0) {
            this.setOxygen(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(REPORT_ASTRONAUT_NAME, this.getName())).append(System.lineSeparator())
        .append(String.format(REPORT_ASTRONAUT_OXYGEN, this.getOxygen())).append(System.lineSeparator())
        .append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, this.getBag().toString()))
        .append(System.lineSeparator());

        return sb.toString();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }

    protected void setOXYGEN_VALUE_TO_DECREASE(double oxygenValueToDecrease) {
        this.OXYGEN_VALUE_TO_DECREASE = oxygenValueToDecrease;
    }
}
