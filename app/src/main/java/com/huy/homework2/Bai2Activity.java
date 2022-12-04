package com.huy.homework2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.adapter.Mes_sendAdapter;
import com.huy.homework2.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Bai2Activity extends AppCompatActivity {
    private RecyclerView rcvMes_send;
    private List<Message> mListMes_send;
    private Mes_sendAdapter mes_sendAdapter;
    Button send_button;
    EditText mes_in_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        rcvMes_send = findViewById(R.id.list_mes_send);
        mListMes_send = new ArrayList<>();

        mListMes_send.add(new Message("Xin chao"));
        mListMes_send.add(new Message("Toi ten la"));
        mListMes_send.add(new Message("Bui Tran Diep Huy"));

        mes_sendAdapter = new Mes_sendAdapter(mListMes_send);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMes_send.setLayoutManager(linearLayoutManager);
        rcvMes_send.setAdapter(mes_sendAdapter);
        send_button = findViewById(R.id.send_button);
        mes_in_box = findViewById(R.id.mes_send_box);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mes_in_box.getText().toString().trim().isEmpty()){

                    mListMes_send.add(new Message(mes_in_box.getText().toString()));
                    mes_sendAdapter.notifyItemInserted(mes_sendAdapter.getItemCount() - 1);
                    rcvMes_send.scrollToPosition(mes_sendAdapter.getItemCount() - 1);

                    mListMes_send.add(new Message("This is a receive message",1));
                    mes_sendAdapter.notifyItemInserted(mes_sendAdapter.getItemCount() - 1);
                    rcvMes_send.scrollToPosition(mes_sendAdapter.getItemCount() - 1);

                    mes_in_box.setText("");
                }
            }
        });
    }
}

