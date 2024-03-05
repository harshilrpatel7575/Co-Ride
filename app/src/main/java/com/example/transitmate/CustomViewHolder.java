package com.example.transitmate;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView chatName;
    public ImageView chatImg;
    public ImageButton confirm, decline;
    public CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        chatName = itemView.findViewById(R.id.chatNameItem);
        chatImg = itemView.findViewById(R.id.chatImgItem);
        confirm = itemView.findViewById(R.id.confirmItem);
        decline = itemView.findViewById(R.id.declineItem);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
