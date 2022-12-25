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

public class EditActivity extends AppCompatActivity {
    public static final String USER_KEY = "user_key";
    private EditText edtName_EDIT, edtNumber_EDIT;
    private Button btnSave_change;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setTitle("EDIT");
        edtName_EDIT = findViewById(R.id.edtName_EDIT);
        edtNumber_EDIT = findViewById(R.id.edtNumber_EDIT);
        AppDatabase db = MyDatabase.getInstance(this);
        btnSave_change = findViewById(R.id.btnSave_change);
        btnSave_change.setOnClickListener(view -> {
            String name = edtName_EDIT.getText().toString();
            String number = edtNumber_EDIT.getText().toString();
            if (!name.equals("") && !number.equals("")) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {

                        user.setName(name);
                        user.setNumber(number);
                        db.userDao().update(user);
// Handle with view
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

        user = getIntent().getParcelableExtra(USER_KEY);
        if (user != null) {
            edtName_EDIT.setText(user.getName());
            edtNumber_EDIT.setText(user.getNumber());
        }
    }

}
