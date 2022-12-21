package com.huy.dialog_homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {
    private List<Color> mListColor;
    int selected_item_position = -1;

    public void setData(List<Color> list) {
        this.mListColor = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        Color color = mListColor.get(position);
        if (color == null) {
            return;
        }
        holder.imgColor.setImageResource(color.getResourceId());
        if (selected_item_position == position) {
            holder.imgChecked.setVisibility(View.VISIBLE);
        } else {
            holder.imgChecked.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (mListColor != null) {
            return mListColor.size();
        }
        return 0;
    }

    protected class ColorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgColor, imgChecked;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            imgColor = itemView.findViewById(R.id.img_color);
            imgChecked = itemView.findViewById(R.id.img_checked);

            imgColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelected(getAdapterPosition());
                }
            });
        }
    }

    public int getSelectedItemPosition(){
        return selected_item_position;
    }

    private void setSelected(int adapterPosition) {
        if (adapterPosition == RecyclerView.NO_POSITION)
            return;
        notifyItemChanged(selected_item_position);
        selected_item_position = adapterPosition;
        notifyItemChanged(selected_item_position);

    }

}
