package com.huy.homework2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.adapter.StudentAdapter;
import com.huy.homework2.model.Student;
import com.huy.homework2.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Bai1Activity extends AppCompatActivity {
    private RecyclerView rcvHocsinh;
    private List<Object> mListHocsinh;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        rcvHocsinh = findViewById(R.id.listStudent);
        mListHocsinh = new ArrayList<>();

        mListHocsinh.add(new Student("A", "acb@gmail.com", 12));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 13));
        mListHocsinh.add(new Teacher("a", "bahbckja@gmail.com", 12.5F));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 14));
        mListHocsinh.add(new Teacher("b", "bahbckja@gmail.com", 142.5F));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 15));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 16));
        mListHocsinh.add(new Teacher("d", "bahbckja@gmail.com", 154752.5F));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 17));
        mListHocsinh.add(new Student("A", "acb@gmail.com", 18));
        mListHocsinh.add(new Teacher("c", "bahbckja@gmail.com", 1542.5F));


        studentAdapter = new StudentAdapter(mListHocsinh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvHocsinh.setLayoutManager(linearLayoutManager);
        rcvHocsinh.setAdapter(studentAdapter);
    }
}