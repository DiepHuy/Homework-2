package com.android.intent_example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String DATA_KEY = "data_key";
    public static final String STUDENT_KEY = "student";
    public static final String SHARE_PREF_RESULT_KEY = "result";
    private static final int PICK_PHOTO_RC = 1001;
    private static final int SCREEN_2_RC = 1002;

    private SharedPreferences sharedPreferences;
    private Button mBtnPickPhoto;
    private Button mBtnMove;
    private ImageView mImg;
    private EditText mEdt;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("sharepref", MODE_PRIVATE);

        mBtnPickPhoto = findViewById(R.id.btnPickPhoto);
        mBtnMove = findViewById(R.id.btnMove);
        mImg = findViewById(R.id.img);

        mEdt = findViewById(R.id.edt);

        mTvResult = findViewById(R.id.tvResult);

        mBtnPickPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Use:"), PICK_PHOTO_RC);
            }
        });

        mBtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(DATA_KEY, mEdt.getText().toString());
                intent.putExtra(STUDENT_KEY, new Student("HUy", 18));
                startActivityForResult(intent, SCREEN_2_RC);
            }
        });

        //get result from share preference
        String resultString = sharedPreferences.getString(SHARE_PREF_RESULT_KEY, "");
        mTvResult.setText(resultString);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_RC) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                mImg.setImageURI(uri);
            } else {
                Toast.makeText(this, "" + resultCode, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == SCREEN_2_RC) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra(MainActivity2.RESULT_KEY);
                mTvResult.setText(result);

                //save result to share preference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SHARE_PREF_RESULT_KEY, result);
                editor.commit();
            }
        }
    }
}