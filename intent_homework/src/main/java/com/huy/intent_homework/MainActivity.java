package com.huy.intent_homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String SHARE_PREF_RESULT_KEY = "SHARE_PREF_RESULT_KEY";
    public static final String INPUT_A_KEY = "INPUT_A_KEY";
    public static final String INPUT_B_KEY = "INPUT_B_KEY";
    private static final int CALCULATE_SCREEN = 1;

    private SharedPreferences sharedPreferences;
    private EditText mEdtA, mEdtB;
    public String stringResult, stringKey, stringA, stringB;
    public TextView mTvLastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("share pref", MODE_PRIVATE);
        getSupportActionBar().setTitle("Main Activity");

        mEdtA = findViewById(R.id.edtInputA);
        mEdtB = findViewById(R.id.edtInputB);
        Button mBtnNext = findViewById(R.id.btnNext);
        TextView mTvResult = findViewById(R.id.tvResult);
        mTvLastResult = findViewById(R.id.tvLastResult);


        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calculate_Activity.class);
                intent.putExtra(INPUT_A_KEY, mEdtA.getText().toString());
                intent.putExtra(INPUT_B_KEY, mEdtB.getText().toString());
                startActivityForResult(intent, CALCULATE_SCREEN);
                finish();
            }
        });
        stringResult = getIntent().getStringExtra(Calculate_Activity.INPUT_MATH_KEY);
        stringKey = getIntent().getStringExtra(Calculate_Activity.INPUT_KEY);
        stringA = getIntent().getStringExtra(Calculate_Activity.INPUT_A_KEY);
        stringB = getIntent().getStringExtra(Calculate_Activity.INPUT_B_KEY);
        if (stringKey != null || stringResult != null) {
            mTvResult.setText(stringA + " " + stringKey + " " + stringB + " = " + stringResult);

            //save result to share preference
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SHARE_PREF_RESULT_KEY, stringA + " " + stringKey + " " + stringB + " = " + stringResult);
            editor.commit();

            //get result from share preference
            String resultString = sharedPreferences.getString(SHARE_PREF_RESULT_KEY, " ");
            mTvLastResult.setText(resultString);
        }
    }
}