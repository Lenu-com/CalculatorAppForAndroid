package to.msn.wings.calculator.model;

public class CalculatorLogic {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0で割ることはできません");
        }
        return a / b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
