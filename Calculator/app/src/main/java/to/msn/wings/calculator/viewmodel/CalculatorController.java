package to.msn.wings.calculator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import to.msn.wings.calculator.model.CalculatorLogic;

public class CalculatorController {
    public enum Operator {
        ADD, SUB, MUL, DIV, NONE
    }
    private final MutableLiveData<String> displayText = new MutableLiveData<>();
    private Operator selectedOperator = Operator.NONE;
    private double storedNumber = 0.0;
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();

    public CalculatorController() {
        displayText.setValue("0");
    }

    public LiveData<String> getDisplayText() {
        return displayText;
    }

    private String formattedNumberText(double number) {
        if (Math.floor(number) == number) {
            return String.valueOf((int) number);
        }
        return String.valueOf(number);
    }

    private void updateSelectedOperator(String operatorButtonText) {
        if (operatorButtonText == null) {
            return;
        }
        switch (operatorButtonText) {
            case "+":
                selectedOperator = Operator.ADD;
                break;
            case "-":
                selectedOperator = Operator.SUB;
                break;
            case "×":
                selectedOperator = Operator.MUL;
                break;
            case "÷":
                selectedOperator = Operator.DIV;
                break;
        }
    }

    private void updateDisplayNumber(String numberText) {
        String currentDisplayText = displayText.getValue();
        if (numberText == null || currentDisplayText == null) {
            return;
        }
        if (numberText.equals("0") && currentDisplayText.equals("0")) {
            return;
        }
        if (currentDisplayText.equals("0")) {
            displayText.setValue(numberText);
            return;
        }
        displayText.setValue(currentDisplayText + numberText);
    }

    private void appendDotToDisplayNumber() {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        if (currentDisplayText.contains(".")) {
            return;
        }
        displayText.setValue(currentDisplayText + ".");
    }

    private void currentNumberClear() {
        displayText.setValue("0");
    }

    private void allClear() {
        displayText.setValue("0");
        selectedOperator = Operator.NONE;
        storedNumber = 0.0;
    }

    private void changeSignOfDisplayNumber() {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        double currentNumber = Double.parseDouble(currentDisplayText);
        double signChangedNumber = calculatorLogic.toggleSign(currentNumber);
        displayText.setValue(formattedNumberText(signChangedNumber));
    }

    private void preformCalculationAndUpdateDisplayNumber() {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        double currentNumber = Double.parseDouble(currentDisplayText);
        double result = calculatorLogic.calculate(storedNumber, currentNumber, selectedOperator);
        displayText.setValue(formattedNumberText(result));
        selectedOperator = Operator.NONE;
    }

    public void onAllClearButtonClicked() {
        allClear();
    }

    public void onNumberButtonClicked(String numberButtonText) {
        if (selectedOperator != Operator.NONE) {
            currentNumberClear();
        }
        updateDisplayNumber(numberButtonText);
    }

    public void onOperatorButtonClicked(String operatorButtonText) {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        if (selectedOperator != Operator.NONE) {
            updateSelectedOperator(operatorButtonText);
            preformCalculationAndUpdateDisplayNumber();
            return;
        }
        updateSelectedOperator(operatorButtonText);
        storedNumber = Double.parseDouble(displayText.getValue());
    }

    public void onEqualsButtonClicked() {
        preformCalculationAndUpdateDisplayNumber();
    }

    public void onDotButtonClicked() {
        appendDotToDisplayNumber();
    }

    public void onSignButtonClicked() {
        changeSignOfDisplayNumber();
    }
}