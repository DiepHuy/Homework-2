package com.huy.homework2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.R;
import com.huy.homework2.model.HocSinh;

import java.util.List;

public class HocSinhAdapter extends RecyclerView.Adapter<HocSinhAdapter.HocSinhViewHolder>{
    private List<HocSinh> mHocSinhList;

    public HocSinhAdapter(List<HocSinh> mHocSinhList) {
        this.mHocSinhList = mHocSinhList;
    }

    @NonNull
    @Override
    public HocSinhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hocsinh, parent, false);
        return new HocSinhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HocSinhViewHolder holder, int position) {
        HocSinh hocSinh = mHocSinhList.get(position);
        if (hocSinh == null){
            return;
        }
        holder.ten_hocsinh.setText(hocSinh.getTenhocsinh());
        holder.email_hocsinh.setText(hocSinh.getEmailhocsinh());
        holder.tuoi_hocsinh.setText(hocSinh.getTuoihocsinh());
    }

    @Override
    public int getItemCount() {
        if (mHocSinhList != null){
            return mHocSinhList.size();
        }
        return 0;
    }

    class HocSinhViewHolder extends RecyclerView.ViewHolder {
        private TextView ten_hocsinh, email_hocsinh, tuoi_hocsinh;
        public HocSinhViewHolder(@NonNull View itemView) {
            super(itemView);
            ten_hocsinh = itemView.findViewById(R.id.ten_hocsinh);
            email_hocsinh = itemView.findViewById(R.id.email_hocsinh);
            tuoi_hocsinh = itemView.findViewById(R.id.tuoi_hocsinh);
        }
    }
}
