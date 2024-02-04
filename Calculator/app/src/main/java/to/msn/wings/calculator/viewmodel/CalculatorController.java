package to.msn.wings.calculator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import to.msn.wings.calculator.model.CalculatorLogic;

public class CalculatorController {
    private enum Operator {
        DIVIDE,
        MULTIPLY,
        SUBTRACT,
        ADD,
        NONE
    }

    private final CalculatorLogic calculatorLogic = new CalculatorLogic();
    private final MutableLiveData<String> displayText = new MutableLiveData<>();

    public LiveData<String> getDisplayText() {
        return displayText;
    }

    public void formatNumberForDisplay(double number) {
        if (Math.floor(number) == number) {
            displayText.setValue(String.valueOf((int) number));
        } else {
            displayText.setValue(String.valueOf(number));
        }
    }

    public void onAllClearButtonClicked() {
        /* TODO: currentNumber. storedNumberの初期化処理を追加する */
        displayText.setValue("0");
    }

    public void onNumberButtonClicked(String number) {
        String currentText = displayText.getValue();
        if (currentText == null) {
            currentText = "0";
        }
        if (currentText.equals("0")) {
            displayText.setValue(number);
        } else {
            displayText.setValue(currentText + number);
        }
    }

    public void onSignButtonClicked() {
        String currentText = displayText.getValue();
        if (currentText == null) {
            return;
        }
        double currentNumber = Double.parseDouble(currentText);
        formatNumberForDisplay(calculatorLogic.toggleSign(currentNumber));
    }

    public void onPercentButtonClicked() {
        String currentText = displayText.getValue();
        if (currentText == null) {
            return;
        }
        double currentNumber = Double.parseDouble(currentText);
        formatNumberForDisplay(calculatorLogic.percent(currentNumber));
    }

    public void onDotButtonClicked() {
        String currentText = displayText.getValue();
        if (currentText == null) {
            displayText.setValue("0.");
        } else if (!currentText.contains(".")) {
            displayText.setValue(currentText + ".");
        }
    }
}
