package com.huy.homework2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.R;
import com.huy.homework2.model.Message;

import java.util.List;

public class Mes_sendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SEND_TYPE=100;
    private static final int RECEIVE_TYPE=101;


    private List<Message> mMessageList;

    public Mes_sendAdapter(List<Message> mMessageList) {
        this.mMessageList = mMessageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==SEND_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mes_send, parent, false);
            return new Mes_sendViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mes_receive, parent, false);
            return new Mess_recieveHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = mMessageList.get(position);
        if (message.getType() == 0){
            return SEND_TYPE;
        }else {
            return RECEIVE_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message mes_send = mMessageList.get(position);
        if (mes_send == null) {
            return;
        }
        if (holder instanceof Mes_sendViewHolder) {
            ((Mes_sendViewHolder)holder).message.setText(mes_send.getContent());
        }else if (holder instanceof Mess_recieveHolder) {
            ((Mess_recieveHolder)holder).message111.setText(mes_send.getContent());
        }
    }

    @Override
    public int getItemCount() {
        if (mMessageList != null) {
            return mMessageList.size();
        }
        return 0;
    }

    class Mes_sendViewHolder extends RecyclerView.ViewHolder {
        private TextView message;

        public Mes_sendViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.mes_send);
        }
    }

    class Mess_recieveHolder extends RecyclerView.ViewHolder {
        private TextView message111;

        public Mess_recieveHolder(@NonNull View itemView) {
            super(itemView);
            message111 = itemView.findViewById(R.id.mes_recv);
        }
    }
}
