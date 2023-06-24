package com.example.memoryenhancer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ColorViewHolder extends RecyclerView.ViewHolder {
    TextView color_name;

    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);

        color_name = itemView.findViewById(R.id.color_name);
    }
}
