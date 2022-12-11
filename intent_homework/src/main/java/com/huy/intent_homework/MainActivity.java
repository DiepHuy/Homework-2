package com.huy.intent_homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String SHARE_PREF_RESULT_KEY = "SHARE_PREF_RESULT_KEY";
    public static final String INPUT_A_KEY = "INPUT_A_KEY";
    public static final String INPUT_B_KEY = "INPUT_B_KEY";
    private static final int CALCULATE_SCREEN = 1;

    private SharedPreferences sharedPreferences;
    private EditText mEdtA, mEdtB;
    public String stringResult, stringKey, stringA, stringB;
    public TextView mTvLastResult;
    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("share pref", MODE_PRIVATE);
        getSupportActionBar().setTitle("Main Activity");

        mEdtA = findViewById(R.id.edtInputA);
        mEdtB = findViewById(R.id.edtInputB);
        Button mBtnNext = findViewById(R.id.btnNext);
        mTvResult = findViewById(R.id.tvResult);
        mTvLastResult = findViewById(R.id.tvLastResult);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calculate_Activity.class);
                intent.putExtra(INPUT_A_KEY, mEdtA.getText().toString());
                intent.putExtra(INPUT_B_KEY, mEdtB.getText().toString());
                startActivityForResult(intent, CALCULATE_SCREEN);
            }
        });

        //show last result from share preference
        String lastResult = sharedPreferences.getString(SHARE_PREF_RESULT_KEY,"");
        mTvLastResult.setText(lastResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALCULATE_SCREEN) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra(Calculate_Activity.INPUT_MATH_KEY);
                mTvLastResult.setText(result);

                //save result to share preference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SHARE_PREF_RESULT_KEY, result);
                editor.commit();

                stringResult = data.getStringExtra(Calculate_Activity.INPUT_MATH_KEY);
                stringKey = data.getStringExtra(Calculate_Activity.INPUT_KEY);
                stringA = data.getStringExtra(Calculate_Activity.INPUT_A_KEY);
                stringB = data.getStringExtra(Calculate_Activity.INPUT_B_KEY);
                if (stringKey != null || stringResult != null) {
                    mTvResult.setText(stringA + " " + stringKey + " " + stringB + " = " + stringResult);

                    //get result from share preference
                    String resultString = sharedPreferences.getString(SHARE_PREF_RESULT_KEY, "A");
                    mTvLastResult.setText(resultString);
                }
            }
        }
    }
}