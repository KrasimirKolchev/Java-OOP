package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 70.0;
    private static final double OXYGEN_VALUE_TO_DECREASE = 5;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
        super.setOXYGEN_VALUE_TO_DECREASE(OXYGEN_VALUE_TO_DECREASE);
    }


}
