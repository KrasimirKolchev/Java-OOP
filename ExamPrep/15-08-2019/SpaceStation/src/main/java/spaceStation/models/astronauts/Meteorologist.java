package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 90;
    private static final double OXYGEN_VALUE_TO_DECREASE = 10;

    public Meteorologist(String name) {
        super(name, INITIAL_OXYGEN);
        super.setOXYGEN_VALUE_TO_DECREASE(OXYGEN_VALUE_TO_DECREASE);
    }
}
