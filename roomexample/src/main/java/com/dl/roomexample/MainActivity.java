package com.dl.roomexample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dl.roomexample.database.AppDatabase;
import com.dl.roomexample.database.AppExecutors;
import com.dl.roomexample.database.MyDatabase;
import com.dl.roomexample.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AppDatabase db;
    private List<User> list = new ArrayList<>();
    private UserAdapter mAdapter;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        db = MyDatabase.getInstance(this);

        mAdapter = new UserAdapter(list);
        mAdapter.setListener(new UserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().delete(user);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadUsers();
                            }
                        });
                    }
                });
            }
        });
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.firstName = "Fist";
                user.lastName = "Last " + i;

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().insertAll(user);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadUsers();
                            }
                        });
                    }
                });
                i++;
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
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
