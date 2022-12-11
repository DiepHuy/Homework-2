package com.android.intent_example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static final String RESULT_KEY = "result";

    private TextView mTv;

    private Button mBtnOk;
    private EditText mEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTv = findViewById(R.id.tv);

        mBtnOk = findViewById(R.id.btnOK);
        mEdt = findViewById(R.id.edt);

        String stringData = getIntent().getStringExtra(MainActivity.DATA_KEY);
        mTv.setText(stringData);

        Student student = getIntent().getParcelableExtra(MainActivity.STUDENT_KEY);
        Toast.makeText(this, "" + student.name + " - " + student.age, Toast.LENGTH_SHORT).show();

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_KEY, mEdt.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
