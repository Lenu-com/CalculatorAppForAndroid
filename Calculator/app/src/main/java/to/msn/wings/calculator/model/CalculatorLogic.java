package to.msn.wings.calculator.model;

public class CalculatorLogic {
    public double toggleSign(double currentNumber) {
        return currentNumber * -1;
    }

    public double percent(double currentNumber) {
        return currentNumber / 100;
    }

    public double divide(double currentNumber, double storedNumber) {
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
}
