package to.msn.wings.calculator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import to.msn.wings.calculator.model.CalculatorLogic;

public class CalculatorController {
    public enum Operator {
        ADD, SUB, MUL, DIV, NONE;

        public boolean isHighPriority() {
            return this == MUL || this == DIV;
        }

        public boolean isNone() {
            return this == NONE;
        }
    }

    private final MutableLiveData<String> displayText = new MutableLiveData<>();
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();
    private double accumulator = 0.0;
    private double currentNumber = 0.0;
    private Operator currentOperator = Operator.NONE;
    private Operator lastOperator = Operator.NONE;

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

    private void preformCalculationAndUpdateDisplayNumber() {
    }

    private void currentNumberClear() {
        displayText.setValue("0");
    }

    public void onNumberButtonClicked(String numberButtonText) {
        if (currentOperator.isNone()) {
            currentNumberClear();
        }
        updateDisplayNumber(numberButtonText);
    }
}