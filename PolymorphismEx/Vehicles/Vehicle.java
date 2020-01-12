package PolymorphismEx.Vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;
    private double distance;

    Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.distance = 0;
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
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
