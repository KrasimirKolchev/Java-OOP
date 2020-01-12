package workshop.boatRacingSimulator.core.models.boats;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.boatEngine.BoatEngine;
import workshop.boatRacingSimulator.core.models.race.Race;

public class PowerBoat extends Boat implements Speed {
    private BoatEngine engine1;
    private BoatEngine engine2;

    public PowerBoat(String model, int weight, BoatEngine engine1, BoatEngine engine2) throws ArgumentException {
        super(model, weight);
        this.engine1 = engine1;
        this.engine2 = engine2;
    }

    private BoatEngine getEngine1() {
        return this.engine1;
    }

    private void setEngine1(BoatEngine engine1) {
        this.engine1 = engine1;
    }

    private BoatEngine getEngine2() {
        return this.engine2;
    }

    private void setEngine2(BoatEngine engine2) {
        this.engine2 = engine2;
    }

    @Override
    public double calcBoatSpeed(Race race) {
        return (this.getEngine1().getOutput() + this.getEngine2().getOutput())
                - this.getWeight() + (race.getOceanCurrentSpeed() / 5);
    }

    @Override
    public boolean isMotorboat() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
