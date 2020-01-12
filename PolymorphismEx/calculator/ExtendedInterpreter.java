package PolymorphismEx.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExtendedInterpreter extends InputInterpreter {
    private Deque<Integer> memory;

    public ExtendedInterpreter(CalculationEngine engine) {
        super(engine);
        this.memory = new ArrayDeque<>();
    }

    @Override
    public Operation getOperation(String operand) {
        Operation operation = super.getOperation(operand);

        if (operation == null) {
            if (operand.equals("/")) {
                return new DivisionOperation();
            } else if (operand.equals("ms")) {
                return new MemorySafeOperation(this.memory);
            } else if (operand.equals("mr")) {
                return new MemoryRecallOperation(this.memory);
            }
        }
        return operation;
    }
}
