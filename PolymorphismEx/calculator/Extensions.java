package PolymorphismEx.calculator;

public class Extensions {

    public static ExtendedInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtendedInterpreter(engine);
    }
}
