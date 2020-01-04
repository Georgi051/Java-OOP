package polymorphism.calculator;

import java.util.Deque;

public class MemorySaveOperation implements Operation {
    private Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        int result= 0;
        if (this.memory.size() > 0){
            result = this.memory.peek();
        }
       return result;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
