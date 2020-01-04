package polymorphism.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputInterpreter {
    private CalculationEngine engine;
    private Deque<Integer> memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public void interpret(String input) {
        try {
            this.engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            this.engine.pushOperation(this.getOperation(input));
        }
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return new MemorySaveOperation(this.memory);
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memory);
        }
        return null;
    }
}
