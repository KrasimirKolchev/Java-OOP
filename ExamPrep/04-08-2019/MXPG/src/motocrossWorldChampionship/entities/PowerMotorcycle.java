package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class PowerMotorcycle extends MotorcycleImpl {
    private static final double DEFAULT_CUBIC_CM = 450;
    private static final int MINIMUM_HORSEPOWER = 70;
    private static final int MAXIMUM_HORSEPOWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CM);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAXIMUM_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        } else {
            super.setHorsePower(horsePower);
        }
    }
}
