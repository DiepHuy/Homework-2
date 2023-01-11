package com.huy.homework3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huy.homework3.data.AppDatabase;
import com.huy.homework3.data.AppExecutors;
import com.huy.homework3.data.MyDatabase;
import com.huy.homework3.data.User;

public class AddActivity extends AppCompatActivity {
    private EditText edtName, edtNumber;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setTitle("ADD");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        AppDatabase db = MyDatabase.getInstance(this);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view -> {
            if (!edtName.getText().toString().equals("") && !edtNumber.getText().toString().equals("")) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().insertAll(new User(edtName.getText().toString(), edtNumber.getText().toString()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setResult(RESULT_OK);
                                finish();
                            }
                        });
                    }
                });
            }
        });
    }
}
