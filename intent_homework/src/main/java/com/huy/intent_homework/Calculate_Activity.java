package com.huy.intent_homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculate_Activity extends AppCompatActivity {
    public static final String RESULT_KEY = "result";
    public static final String INPUT_MATH_KEY = "INPUT_MATH_KEY";
    public static final String INPUT_KEY = "INPUT_KEY";
    public static final String INPUT_A_KEY = "INPUT_A_KEY";
    public static final String INPUT_B_KEY = "INPUT_B_KEY";
    private TextView mTv_A;
    private TextView mTv_B;
    public String DataA, DataB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        getSupportActionBar().setTitle("Calculate Activity");

        Button mBtnPlus = findViewById(R.id.btnPlus);
        Button mBtnMinus = findViewById(R.id.btnMinus);
        Button mBtnMultiple = findViewById(R.id.btnMultiple);
        Button mBtnDivide = findViewById(R.id.btnDivide);

        mTv_A = findViewById(R.id.tvInputA);
        DataA = getIntent().getStringExtra(MainActivity.INPUT_A_KEY);
        mTv_A.setText("A = " + DataA);
        Float A = Float.parseFloat(DataA);

        mTv_B = findViewById(R.id.tvInputB);
        DataB = getIntent().getStringExtra(MainActivity.INPUT_B_KEY);
        mTv_B.setText("B = " + DataB);
        Float B = Float.parseFloat(DataB);

        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate_Activity.this, MainActivity.class);
                intent.putExtra(INPUT_MATH_KEY, String.valueOf(A+B));
                intent.putExtra(INPUT_KEY,"+");
                intent.putExtra(INPUT_A_KEY, DataA);
                intent.putExtra(INPUT_B_KEY, DataB);

                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        });

        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate_Activity.this, MainActivity.class);
                intent.putExtra(INPUT_MATH_KEY, String.valueOf(A-B));
                intent.putExtra(INPUT_KEY,"-");
                intent.putExtra(INPUT_A_KEY, DataA);
                intent.putExtra(INPUT_B_KEY, DataB);

                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        });

        mBtnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate_Activity.this, MainActivity.class);
                intent.putExtra(INPUT_MATH_KEY, String.valueOf(A*B));
                intent.putExtra(INPUT_KEY,"×");
                intent.putExtra(INPUT_A_KEY, DataA);
                intent.putExtra(INPUT_B_KEY, DataB);

                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        });

        mBtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate_Activity.this, MainActivity.class);
                intent.putExtra(INPUT_MATH_KEY, String.valueOf(A/B));
                intent.putExtra(INPUT_KEY,"÷");
                intent.putExtra(INPUT_A_KEY, DataA);
                intent.putExtra(INPUT_B_KEY, DataB);

                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        });
    }
}
