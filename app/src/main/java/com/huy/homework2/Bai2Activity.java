package com.huy.homework2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.adapter.HocSinhAdapter;
import com.huy.homework2.adapter.Mes_sendAdapter;
import com.huy.homework2.model.HocSinh;
import com.huy.homework2.model.Mes_send;

import java.util.ArrayList;
import java.util.List;

public class Bai2Activity extends AppCompatActivity {
    private RecyclerView rcvMes_send;
    private List<Mes_send> mListMes_send;
    private Mes_sendAdapter mes_sendAdapter;
    Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        rcvMes_send = findViewById(R.id.listHocSinh);
        mListMes_send = new ArrayList<>();

        mListMes_send.add(new Mes_send("Xin chao"));
        mListMes_send.add(new Mes_send("Toi ten la"));
        mListMes_send.add(new Mes_send("Bui Tran Diep Huy"));

        mes_sendAdapter = new Mes_sendAdapter(mListMes_send);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMes_send.setLayoutManager(linearLayoutManager);
        rcvMes_send.setAdapter(mes_sendAdapter);
        send_button = findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListMes_send.add(new Mes_send("HUY"));
            }
        });
    }
}

