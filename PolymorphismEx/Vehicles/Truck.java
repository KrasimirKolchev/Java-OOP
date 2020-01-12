package PolymorphismEx.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double CONS_AIRCONDITION = 1.6;
    private static final double FUEL_LOSS = 0.95;

    Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void drive(double distance) {
        if (((this.getLitersPerKm() + CONS_AIRCONDITION) * distance) <= this.getFuelQuantity()) {
            this.setDistance(this.getDistance() + distance);
            this.setFuelQuantity(this.getFuelQuantity() - ((this.getLitersPerKm() + CONS_AIRCONDITION) * distance));
        } else {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Truck travelled %s km", df.format(distance)));
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + (liters * FUEL_LOSS));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
