package com.example.enerdash.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enerdash.R;
import com.example.enerdash.helpers.Events.ItemTapListener;

public class ElectroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvName;
    public ImageView ivImg;
    @Nullable
    private final ItemTapListener mTapListener;

    public ElectroViewHolder(@NonNull View itemView, @Nullable ItemTapListener tapListener) {
        super(itemView);

        mTapListener = tapListener;
        itemView.setOnClickListener(this);

        ivImg = itemView.findViewById(R.id.iv_NameImg);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void onClick(View view) {
        if(mTapListener == null) return;
        mTapListener.onItemTap(view, getAdapterPosition());
    }
}
