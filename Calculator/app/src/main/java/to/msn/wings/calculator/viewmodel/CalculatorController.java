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

    private void updateDisplayTextWithNumber(String numberText) {
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

    private void appendDotToDisplayText() {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        if (currentDisplayText.contains(".")) {
            return;
        }
        displayText.setValue(currentDisplayText + ".");
    }

    private void changeSignOfDisplayText() {
        String currentDisplayText = displayText.getValue();
        if (currentDisplayText == null) {
            return;
        }
        double currentNumber = Double.parseDouble(currentDisplayText);
        double signChangedNumber = calculatorLogic.toggleSign(currentNumber);
        displayText.setValue(formattedNumberText(signChangedNumber));
    }

    public void onNumberButtonClicked(String numberButtonText) {
        updateDisplayTextWithNumber(numberButtonText);
    }

    public void onDotButtonClicked() {
        appendDotToDisplayText();
    }

    public void onSignButtonClicked() {
        changeSignOfDisplayText();
    }
}
