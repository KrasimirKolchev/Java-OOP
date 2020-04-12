package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 50;
    private static final double OXYGEN_VALUE_TO_DECREASE = 10;

    public Geodesist(String name) {
        super(name, INITIAL_OXYGEN);
        super.setOXYGEN_VALUE_TO_DECREASE(OXYGEN_VALUE_TO_DECREASE);
    }
}
