package PolymorphismEx.VehiclesExtension;

public abstract class Vehicle {
    private double initialFuelQuantity;
    private double litersPerKm;
    private double tankCapacity;
    private double distance;

    Vehicle(double initialFuelQuantity, double litersPerKm, double tankCapacity) {
        this.initialFuelQuantity = initialFuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
        this.distance = 0;
    }

    double getInitialFuelQuantity() {
        return initialFuelQuantity;
    }

    void setInitialFuelQuantity(double initialFuelQuantity) {
        this.initialFuelQuantity = initialFuelQuantity;
    }

    double getTankCapacity() {
        return tankCapacity;
    }

    double getLitersPerKm() {
        return this.litersPerKm;
    }

    void setDistance(double distance) {
        this.distance = distance;
    }

    double getDistance() {
        return this.distance;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);
}
