package workshop.boatRacingSimulator.core.models.boats;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.race.Race;

public class RowBoat extends Boat implements Speed {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private int getOars() {
        return this.oars;
    }

    private void setOars(int oars) throws ArgumentException {
        if (oars <= 0) {
            throw new ArgumentException("Oars must be a positive integer.");
        }
        this.oars = oars;
    }

    @Override
    public double calcBoatSpeed(Race race) {
        return (this.getOars() * 100) - this.getWeight() + race.getOceanCurrentSpeed();
    }

    @Override
    public boolean isMotorboat() {
        return false;
    }
}
