package to.msn.wings.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 数字ボタンオブジェクトを取得 */
        for (int i = 0; i <= BUTTON_COUNT; i++) {
            int buttonId = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            Button button = findViewById(buttonId);
        }

        /* 数字ボタン以外のオブジェクトを取得 */
        Button btn_AC = (Button) findViewById(R.id.btn_AC);
        Button btn_PM = (Button) findViewById(R.id.btn_PM);
        Button btn_per = (Button) findViewById(R.id.btn_per);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_dot = (Button) findViewById(R.id.btn_dot);
        Button btn_equ = (Button) findViewById(R.id.btn_equ);

    }
}