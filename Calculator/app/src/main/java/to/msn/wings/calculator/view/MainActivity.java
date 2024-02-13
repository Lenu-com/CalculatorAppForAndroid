package to.msn.wings.calculator.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import to.msn.wings.calculator.viewmodel.CalculatorController;

import android.graphics.Color;
import android.os.Bundle;

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
        Button allClear = findViewById(R.id.btn_AC);
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

        calculatorController.getDisplayText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        for (Button button : numberButtons) {
            button.setOnClickListener(v -> {
                String buttonText = ((Button) v).getText().toString();
                calculatorController.onNumberButtonClicked(buttonText);
            });
        }

        dot.setOnClickListener(v -> calculatorController.onDotButtonClicked());
        sign.setOnClickListener(v -> calculatorController.onSignButtonClicked());
    }
}