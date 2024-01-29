package to.msn.wings.calculator.viewmodel;

public class CalculatorController {
    private int currentNumber;
    private int storedNumber;
    private Operator currentOperator;

    public enum Operator {
        DIVIDE,
        MULTIPLY,
        SUBTRACT,
        ADD,
        NONE
    }

    public CalculatorController() {
        this.currentNumber = 0;
        this.storedNumber = 0;
    }

    public void setCurrentNumber(int number) {
        this.currentNumber = number;
    }

    public void setStoredNumber(int number) {
        this.storedNumber = number;
    }

    public void setCurrentOperator(Operator operator) {
        this.currentOperator = operator;
    }

    public int calculate() {
        switch (this.currentOperator) {
            case DIVIDE:
                storedNumber = to.msn.wings.calculator.model.CalculatorLogic.divide(storedNumber, currentNumber);
                break;
            case MULTIPLY:
                storedNumber = to.msn.wings.calculator.model.CalculatorLogic.multiply(storedNumber, currentNumber);
                break;
            case SUBTRACT:
                storedNumber = to.msn.wings.calculator.model.CalculatorLogic.subtract(storedNumber, currentNumber);
                break;
            case ADD:
                storedNumber = to.msn.wings.calculator.model.CalculatorLogic.add(storedNumber, currentNumber);
                break;
            default:
                break;
        }
        currentNumber = 0;
        return currentNumber;
    }
}
