package com.huy.homework2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.R;
import com.huy.homework2.model.HocSinh;
import com.huy.homework2.model.Mes_send;

import java.util.List;

public class Mes_sendAdapter extends RecyclerView.Adapter<Mes_sendAdapter.Mes_sendViewHolder>{
    private List<Mes_send> mMessageList;

    public Mes_sendAdapter(List<Mes_send> mMessageList) {
        this.mMessageList = mMessageList;
    }

    @NonNull
    @Override
    public Mes_sendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mes_send, parent, false);
        return new Mes_sendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mes_sendViewHolder holder, int position) {
        Mes_send mes_send = mMessageList.get(position);
        if (mes_send == null){
            return;
        }
        holder.message.setText(mes_send.getMessage());
    }

    @Override
    public int getItemCount() {
        if (mMessageList != null){
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
}
