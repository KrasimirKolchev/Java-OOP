package workshop.boatRacingSimulator.core.models.boats;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.Model;

public abstract class Boat implements Speed, Model {
    private String model;
    private int weight;

    Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length() < 5) {
            throw new ArgumentException("Model's name must be at least 5 symbols long.");
        }
        this.model = model;
    }

    int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) throws ArgumentException {
        if (weight <= 0) {
            throw new ArgumentException("Weight must be a positive integer.");
        }
        this.weight = weight;
    }

    public abstract boolean isMotorboat();
}
