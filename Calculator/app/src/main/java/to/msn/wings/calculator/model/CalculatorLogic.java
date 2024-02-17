package to.msn.wings.calculator.model;

import to.msn.wings.calculator.viewmodel.CalculatorController;

public class CalculatorLogic {
    public double toggleSign(double currentNumber) {
        return currentNumber * -1;
    }

    public double percent(double currentNumber) {
        return currentNumber / 100;
    }

    public double divide(double currentNumber, double storedNumber) {
        if (currentNumber == 0) {
            throw new IllegalArgumentException();
        }
        return storedNumber / currentNumber;
    }

    public double multiply(double currentNumber, double storedNumber) {
        return storedNumber * currentNumber;
    }

    public double subtract(double currentNumber, double storedNumber) {
        return storedNumber - currentNumber;
    }

    public double add(double currentNumber, double storedNumber) {
        return storedNumber + currentNumber;
    }

    public double calculate(double storedNumber, double currentNumber, CalculatorController.Operator selectedOperator) {
        switch (selectedOperator) {
            case ADD:
                return add(currentNumber, storedNumber);
            case SUB:
                return subtract(currentNumber, storedNumber);
            case MUL:
                return multiply(currentNumber, storedNumber);
            case DIV:
                if (currentNumber == 0) {
                    throw new IllegalArgumentException();
                }
                return divide(currentNumber, storedNumber);
            default:
                return currentNumber;
        }
    }
}