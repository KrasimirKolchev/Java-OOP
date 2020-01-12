package PolymorphismEx.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double CONS_AIRCONDITION = 0.9;

    Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void drive(double distance) {
        if (((this.getLitersPerKm() + CONS_AIRCONDITION) * distance) <= this.getFuelQuantity()) {
            this.setDistance(this.getDistance() + distance);
            this.setFuelQuantity(this.getFuelQuantity() - ((this.getLitersPerKm() + CONS_AIRCONDITION) * distance));
        } else {
            throw new IllegalArgumentException("Cat needs refueling");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Cat travelled %s km", df.format(distance)));
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Cat: %.2f", this.getFuelQuantity());
    }
}
