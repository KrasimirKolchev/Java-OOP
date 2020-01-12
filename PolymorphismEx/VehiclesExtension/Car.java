package PolymorphismEx.VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double CONS_AIRCONDITION = 0.9;

    Car(double initialFuelQuantity, double litersPerKm, double tankCapacity) {
        super(initialFuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        if (((this.getLitersPerKm() + CONS_AIRCONDITION) * distance) <= this.getInitialFuelQuantity()) {
            this.setDistance(this.getDistance() + distance);
            this.setInitialFuelQuantity(this.getInitialFuelQuantity()
                    - ((this.getLitersPerKm() + CONS_AIRCONDITION) * distance));
        } else {
            throw new IllegalArgumentException("Cat needs refueling");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Cat travelled %s km", df.format(distance)));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.getInitialFuelQuantity() + liters > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.setInitialFuelQuantity(this.getInitialFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Cat: %.2f", this.getInitialFuelQuantity());
    }
}
