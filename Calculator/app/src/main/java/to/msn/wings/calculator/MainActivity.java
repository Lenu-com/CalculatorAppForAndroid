package to.msn.wings.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* 同一フォントサイズの桁を定義 */
    private static final int MAX_DIGIT = 6;

    private TextView textView;
    private double storedNumber = 0;
    private String currentOperator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* テキストビューオブジェクトを取得 */
        textView = findViewById(R.id.textView);

        View.OnClickListener allClearClickListener = view -> allClear();

        View.OnClickListener clearClickListener = view -> {
            /* TODO: Cボタンが押された時の処理を実装 */
        };

        View.OnClickListener signClickListener = view -> changeSign();

        View.OnClickListener percentClickListener = view -> convertToPercentage();

        View.OnClickListener dotClickListener = view -> appendDecimalPointIfAbsent();

        View.OnClickListener equalClickListener = view -> {
            if (currentOperator == null) {
                return;
            }
            double currentNumber = Double.parseDouble(textView.getText().toString());
            double result = 0;

            switch (currentOperator) {
                case "+":
                    result = storedNumber + currentNumber;
                    break;
                case "-":
                    result = storedNumber - currentNumber;
                    break;
                case "×":
                    result = storedNumber * currentNumber;
                    break;
                case "÷":
                    if (currentNumber == 0) {
                        textView.setText("エラー");
                        return;
                    }
                    result = storedNumber / currentNumber;
                    break;
            }
            convertDecimalToIntIfApplicable(String.valueOf(result));
            currentOperator = null;
        };

        /* ボタンオブジェクトを取得 */
        setupOperatorButtons();
        setupNumberButtons();
        Button btn_AC = findViewById(R.id.btn_AC);
        Button btn_PM = findViewById(R.id.btn_PM);
        Button btn_per = findViewById(R.id.btn_per);
        Button btn_dot = findViewById(R.id.btn_dot);
        Button btn_equ = findViewById(R.id.btn_equ);

        /* ボタンにリスナーを設定 */
        btn_AC.setOnClickListener(allClearClickListener);
        btn_PM.setOnClickListener(signClickListener);
        btn_per.setOnClickListener(percentClickListener);
        btn_dot.setOnClickListener(dotClickListener);
        btn_equ.setOnClickListener(equalClickListener);
    }

    private void setupNumberButtons() {
        int[] numberButtonIds = {
                R.id.btn_0,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9
        };

        View.OnClickListener numberClickListener = view -> {
            String buttonText = ((Button) view).getText().toString();
            String displayText = textView.getText().toString();
            if (buttonText.equals("0") && displayText.equals("0")) {
                return;
            }
            if (displayText.equals("0")) {
                textView.setText("");
            }
            appendToDisplay(buttonText);
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIds = {
                R.id.btn_div,
                R.id.btn_mul,
                R.id.btn_sub,
                R.id.btn_add
        };

        View.OnClickListener operatorClickListener = view -> {
            if (currentOperator != null) {
                return;
            }
            currentOperator = ((Button) view).getText().toString();
            storedNumber = Double.parseDouble(textView.getText().toString());
            textView.setText("0");
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(operatorClickListener);
        }
    }

    private void appendToDisplay(String text) {

        String currentText = textView.getText().toString();

        /* クリックされたボタンテキストを表示内容に追加 */
        currentText += text;

        /* 表示内容更新 */
        textView.setText(currentText);

        /* 表示桁数が6桁を超えた場合、フォントサイズを小さくする */
        if (currentText.length() > MAX_DIGIT) {
            float scale = (float) MAX_DIGIT / currentText.length();
            textView.setScaleX(scale);
            textView.setScaleY(scale);
        } else {
            /* 元のサイズに戻す */
            textView.setScaleX(1);
            textView.setScaleY(1);
        }
    }


    private void allClear() {
        textView.setText("0");
    }

    private void appendDecimalPointIfAbsent() {
        String currentText = textView.getText().toString();
        if (currentText.contains(".")) {
            return;
        }
        appendToDisplay(".");
    }

    private void convertDecimalToIntIfApplicable(String text) {
        double result = Double.parseDouble(text);
        if (result == Math.floor(result)) {
            textView.setText(String.valueOf((int)result));
            return;
        }
        textView.setText(String.valueOf(result));
    }


    private void convertToPercentage() {
        double result = Double.parseDouble(textView.getText().toString());
        result /= 100;
        convertDecimalToIntIfApplicable(String.valueOf(result));
    }

    private void changeSign() {
        double result = Double.parseDouble(textView.getText().toString());
        result *= -1;
        convertDecimalToIntIfApplicable(String.valueOf(result));
    }
}