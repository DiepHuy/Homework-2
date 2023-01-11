package com.huy.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework3.data.AppDatabase;
import com.huy.homework3.data.AppExecutors;
import com.huy.homework3.data.MyDatabase;
import com.huy.homework3.data.User;
import com.huy.homework3.data.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Dialog.OnUpdateListAfterDeleteListener {
    private static final int ADD_RC = 1001;
    public static final int EDIT_RC = 1002;
    private RecyclerView rcvUser;
    private UserAdapter user_adapter;
    private TextView tvName, tvNumber;
    private Button btnAdd;
    private AppDatabase db;
    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvUser = findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        db = MyDatabase.getInstance(this);
        user_adapter = new UserAdapter(list);
        rcvUser.setAdapter(user_adapter);

        user_adapter.setListener(new UserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                Log.d("xxxx", "onUserClick: ");
                //show dialog
                Dialog dialog = Dialog.newInstance(user);
                dialog.show(getSupportFragmentManager(), Dialog.class.getSimpleName());
            }
        });
        tvName = findViewById(R.id.tv_name);
        tvNumber = findViewById(R.id.tv_number);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddActivity.class), ADD_RC);
            }
        });

        loadUsers();
    }

    private void loadUsers() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<User> ls = db.userDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        list.addAll(ls);
                        user_adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_RC && resultCode == RESULT_OK) {
            loadUsers();
        }
        if (requestCode == EDIT_RC && resultCode == RESULT_OK) {
            loadUsers();
        }
    }

    @Override
    public void updateData() {
        loadUsers();
    }
}