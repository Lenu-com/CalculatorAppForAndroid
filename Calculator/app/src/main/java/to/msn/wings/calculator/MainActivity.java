package to.msn.wings.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* 数字ボタンのオブジェクトを取得する際の定数を宣言 */
    private static final int BUTTON_COUNT = 9;

    private Button btn_AC;
    private Button btn_PM;
    private Button btn_per;
    private Button btn_div;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_mul;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_sub;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_add;
    private Button btn_0;
    private Button btn_dot;
    private Button btn_equ;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 数字ボタンオブジェクトを取得 */
        for (int i = 0; i <= BUTTON_COUNT; i++) {
            int buttonId = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            Button button = findViewById(buttonId);

            /* 数字ボタンにクリックリスナーを設定 */
            setClickListener(button, String.valueOf(i));
        }

        /* 数字ボタン以外のオブジェクトを取得 */
        btn_AC = findViewById(R.id.btn_AC);
        btn_PM = findViewById(R.id.btn_PM);
        btn_per = findViewById(R.id.btn_per);
        btn_div = findViewById(R.id.btn_div);
        btn_mul = findViewById(R.id.btn_mul);
        btn_sub = findViewById(R.id.btn_sub);
        btn_add = findViewById(R.id.btn_add);
        btn_dot = findViewById(R.id.btn_dot);
        btn_equ = findViewById(R.id.btn_equ);

        /* テキストビューオブジェクトを取得 */
        textView = findViewById(R.id.textView);



        /* クリックリスナーの設定 */
        setClickListener(btn_AC, "AC");
        setClickListener(btn_PM, "+/-");
        setClickListener(btn_per, "%");
        setClickListener(btn_div, "÷");
        setClickListener(btn_mul, "×");
        setClickListener(btn_sub, "-");
        setClickListener(btn_add, "+");
        setClickListener(btn_dot, ".");
        setClickListener(btn_equ, "=");
    }

    private void setClickListener(Button button, String buttonText) {
        /* ボタンがクリックされたときの処理 */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* クリックされたボタンのテキストを表示領域に追加 */
                appendToDisplay(buttonText);
            }
        });
    }

    private void appendToDisplay(String text) {

        String currentText = textView.getText().toString();

        /* クリックされたボタンテキストを表示内容に追加 */
        currentText += text;

        /* 表示内容更新 */
        textView.setText(currentText);
    }
}