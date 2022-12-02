package com.huy.homework2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.adapter.HocSinhAdapter;
import com.huy.homework2.model.HocSinh;

import java.util.ArrayList;
import java.util.List;

public class Bai1Activity extends AppCompatActivity {
    private RecyclerView rcvHocsinh;
    private List<HocSinh> mListHocsinh;
    private HocSinhAdapter hocSinhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        rcvHocsinh = findViewById(R.id.listHocSinh);
        mListHocsinh = new ArrayList<>();

        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 12));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 13));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 14));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 15));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 16));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 17));
        mListHocsinh.add(new HocSinh("A", "acb@gmail.com", 18));

        hocSinhAdapter = new HocSinhAdapter(mListHocsinh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvHocsinh.setLayoutManager(linearLayoutManager);
        rcvHocsinh.setAdapter(hocSinhAdapter);
    }
}