package com.huy.recycler_anim_homework;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvUser;
    private UserAdapter user_adapter;
    private Button btnLeft2Right, btnRight2Left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        user_adapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);



        btnLeft2Right = findViewById(R.id.btn_left_2_right);
        btnRight2Left = findViewById(R.id.btn_right_2_left);

        btnLeft2Right.setOnClickListener(this);
        btnRight2Left.setOnClickListener(this);

    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.pic1,"User Name 1","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic2,"User Name 2","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic3,"User Name 3","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic4,"User Name 4","Thanh Khe, Da Nang"));

        list.add(new User(R.drawable.pic1,"User Name 1","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic2,"User Name 2","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic3,"User Name 3","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic4,"User Name 4","Thanh Khe, Da Nang"));

        list.add(new User(R.drawable.pic1,"User Name 1","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic2,"User Name 2","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic3,"User Name 3","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic4,"User Name 4","Thanh Khe, Da Nang"));

        list.add(new User(R.drawable.pic1,"User Name 1","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic2,"User Name 2","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic3,"User Name 3","Thanh Khe, Da Nang"));
        list.add(new User(R.drawable.pic4,"User Name 4","Thanh Khe, Da Nang"));
        return list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_left_2_right:
                setAnimation(R.anim.layout_anim_left2right);
                break;
            case R.id.btn_right_2_left:
                setAnimation(R.anim.layout_anim_right2left);
                break;
        }
    }
    private void setAnimation(int animResource){
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(this,animResource);
        rcvUser.setLayoutAnimation(layoutAnimationController);

        user_adapter.setData(getListUser());
        rcvUser.setAdapter(user_adapter);
    }
}
