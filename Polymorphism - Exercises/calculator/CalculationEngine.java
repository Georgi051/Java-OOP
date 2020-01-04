package polymorphism.calculator;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
    }

    public void pushNumber(int number) {
        if (this.currentOperation != null) {
            this.currentOperation.addOperand(number);

            if (this.currentOperation.isCompleted()) {
                this.result = this.currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }
}
