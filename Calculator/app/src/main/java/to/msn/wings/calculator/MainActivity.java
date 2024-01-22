package to.msn.wings.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int NUMBER_BUTTON_TOTAL = 9;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* テキストビューオブジェクトを取得 */
        textView = findViewById(R.id.textView);

        View.OnClickListener allClearClickListener = view -> {
            /* TODO: ACボタンが押された時の処理を実装 */
        };

        View.OnClickListener clearClickListener = view -> {
            /* TODO: Cボタンが押された時の処理を実装 */
        };

        View.OnClickListener signClickListener = view -> {
            /* TODO: +/-ボタンが押された時の処理を実装 */
        };

        View.OnClickListener percentClickListener = view -> {
            /* TODO: %ボタンが押された時の処理を実装 */
        };

        View.OnClickListener dotClickListener = view -> {
            /* TODO: .ボタンが押された時の処理を実装 */
        };

        View.OnClickListener equalClickListener = view -> {
            /* TODO: =ボタンが押された時の処理を実装 */
        };

        /* ボタンオブジェクトを取得 */
        setupOperatorButtons();
        setupNumberButtons();
        Button btn_AC = findViewById(R.id.btn_AC);
        Button btn_PM = findViewById(R.id.btn_PM);
        Button btn_dot = findViewById(R.id.btn_dot);
        Button btn_equ = findViewById(R.id.btn_equ);

        /* ボタンにリスナーを設定 */
        btn_AC.setOnClickListener(allClearClickListener);
        btn_PM.setOnClickListener(signClickListener);
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
            /* TODO: 演算子ボタンが押された時の処理を実装
              (前述のように演算子毎にクリックリスナーを定義するのもあり) */
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
    }
}