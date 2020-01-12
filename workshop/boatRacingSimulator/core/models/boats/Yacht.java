package workshop.boatRacingSimulator.core.models.boats;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.boatEngine.BoatEngine;
import workshop.boatRacingSimulator.core.models.race.Race;

public class Yacht extends Boat implements Speed {
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.setEngine(engine);
        this.setCargoWeight(cargoWeight);
    }

    private BoatEngine getEngine() {
        return this.engine;
    }

    private void setEngine(BoatEngine engine) {
        this.engine = engine;
    }

    private int getCargoWeight() {
        return this.cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (cargoWeight <= 0) {
            throw new ArgumentException("Cargo Weight must be a positive integer.");
        }
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calcBoatSpeed(Race race) {
        return this.engine.getOutput() - (this.getWeight()
                + this.getCargoWeight()) + (race.getOceanCurrentSpeed() / 2);
    }

    @Override
    public boolean isMotorboat() {
        return true;
    }
}
