package com.dl.roomexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dl.roomexample.database.User;

import java.util.List;

/**
 * Created by DucLe on 21/12/2022.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> list;
    private OnUserClickListener listener;

    public UserAdapter(List<User> ls) {
        this.list = ls;
    }

    public void setListener(OnUserClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);
        holder.mTvName.setText(user.firstName + " " + user.lastName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onUserClick(user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface OnUserClickListener {
        void onUserClick(User user);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
        }
    }
}
