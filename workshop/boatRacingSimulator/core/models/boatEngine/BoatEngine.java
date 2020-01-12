package workshop.boatRacingSimulator.core.models.boatEngine;

import workshop.boatRacingSimulator.core.exceptions.ArgumentException;
import workshop.boatRacingSimulator.core.models.Model;

public class BoatEngine implements Model {
    private String model;
    private int horsePower;
    private int displacement;
    private String type;

    public BoatEngine(String model, int horsePower, int displacement, String type) throws ArgumentException {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setDisplacement(displacement);
        this.setType(type);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length() < 3) {
            throw new ArgumentException("Model's name must be at least 3 symbols long.");
        }
        this.model = model;
    }

    private int getHorsePower() {
        return this.horsePower;
    }

    private void setHorsePower(int horsePower) throws ArgumentException {
        if (horsePower <= 0) {
            throw new ArgumentException("Horsepower must be a positive integer.");
        }
        this.horsePower = horsePower;
    }

    private int getDisplacement() {
        return this.displacement;
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (horsePower <= 0) {
            throw new ArgumentException("Displacement must be a positive integer.");
        }
        this.displacement = displacement;
    }

    private String getType() {
        return this.type;
    }

    private void setType(String type) {
        if (type.equals("Jet") || type.equals("Sterndrive")) {
            this.type = type;
        }
    }

    public int getOutput() {
        if (this.getType().equals("Jet")) {
            return (this.getHorsePower() * 5) + this.getDisplacement();
        }
        return (this.getHorsePower() * 7) + this.getDisplacement();
    }
}
