package workshop.boatRacingSimulator.core.models.boats;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.race.Race;

public class SailBoat extends Boat implements Speed {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private int getSailEfficiency() {
        return this.sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calcBoatSpeed(Race race) {
        return (race.getWindSpeed() * (this.getSailEfficiency() / 100.0))
                - this.getWeight() + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public boolean isMotorboat() {
        return false;
    }
}
