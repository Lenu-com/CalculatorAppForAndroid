package to.msn.wings.calculator.viewmodel;

public class CalculatorController {
    private double currentNumber;
    private double storedNumber;
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

    public void setCurrentNumber(double number) {
        this.currentNumber = number;
    }

    public void setStoredNumber(double number) {
        this.storedNumber = number;
    }

    public void setCurrentOperator(Operator operator) {
        this.currentOperator = operator;
    }

    public double calculate() {
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
