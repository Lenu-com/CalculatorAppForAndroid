package to.msn.wings.calculator.view;

import androidx.appcompat.app.AppCompatActivity;
import to.msn.wings.calculator.viewmodel.CalculatorController;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;

import android.widget.Button;
import android.widget.TextView;

import to.msn.wings.calculator.R;

public class MainActivity extends AppCompatActivity {
    final private CalculatorController calculatorController = new CalculatorController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button btnAC = findViewById(R.id.btn_AC);
        Button sign = findViewById(R.id.btn_PM);
        Button percent = findViewById(R.id.btn_per);
        Button div = findViewById(R.id.btn_div);
        Button mul = findViewById(R.id.btn_mul);
        Button sub = findViewById(R.id.btn_sub);
        Button add = findViewById(R.id.btn_add);
        Button equals = findViewById(R.id.btn_equ);
        Button dot = findViewById(R.id.btn_dot);
        Button zero = findViewById(R.id.btn_0);
        Button one = findViewById(R.id.btn_1);
        Button two = findViewById(R.id.btn_2);
        Button three = findViewById(R.id.btn_3);
        Button four = findViewById(R.id.btn_4);
        Button five = findViewById(R.id.btn_5);
        Button six = findViewById(R.id.btn_6);
        Button seven = findViewById(R.id.btn_7);
        Button eight = findViewById(R.id.btn_8);
        Button nine = findViewById(R.id.btn_9);

        Button[] operatorButtons = {
                div, mul, sub, add
        };

        Button[] numberButtons = {
                zero, one, two, three, four, five, six, seven, eight, nine
        };

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* 実装不要 */
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* 実装不要 */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /* TODO: 桁数が増えた際の処理を実装する */
            }

            public void onTextChanged(CharSequence s, double start, double before, double count) {
                /* TODO: 桁数が増えた際の処理を実装する */
            }
        });

        btnAC.setOnClickListener(view -> {
            /* TODO: ACボタンが押された際の処理を実装する */
        });

        sign.setOnClickListener(view -> {
            /* TODO: ±ボタンが押された際の処理を実装する */
        });

        percent.setOnClickListener(view -> {
            /* TODO: %ボタンが押された際の処理を実装する */
        });

        dot.setOnClickListener(view -> {
            /* TODO: .ボタンが押された際の処理を実装する */
        });

        equals.setOnClickListener(view -> {
            /* TODO: =ボタンが押された際の処理を実装する */
        });

        for (Button button : operatorButtons) {
            button.setOnClickListener(view -> {
                calculatorController.setStoredNumber(Integer.parseInt(textView.getText().toString()));

                if (button.getId() == R.id.btn_div) {
                    calculatorController.setCurrentOperator(CalculatorController.Operator.DIVIDE);
                }

                if (button.getId() == R.id.btn_mul) {
                    calculatorController.setCurrentOperator(CalculatorController.Operator.MULTIPLY);
                }

                if (button.getId() == R.id.btn_sub) {
                    calculatorController.setCurrentOperator(CalculatorController.Operator.SUBTRACT);
                }

                if (button.getId() == R.id.btn_add) {
                    calculatorController.setCurrentOperator(CalculatorController.Operator.ADD);
                }
            });
        }

        for (Button button : numberButtons) {
            button.setOnClickListener(view -> {
                /* TODO: 数字ボタンが押された際の共通処理を実装する */
            });
        }
    }

    private void updateTextView(String text) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }

    private void updateTextView(double number) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(number));
    }

    private void updateTextView(int number) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(number));
    }
}