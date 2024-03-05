package com.example.transitmate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<ChatItem> chatList;
    private SelectListener listener;

    public CustomAdapter(Context context, List<ChatItem> chatList, SelectListener listener) {
        this.context = context;
        this.chatList = chatList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.messages_list_item, parent, false);

        return new CustomViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.chatName.setText(chatList.get(position).name);
        int id = context.getResources().getIdentifier("drawable/" + (chatList.get(position).imgResource), null, context.getPackageName());
        holder.chatImg.setImageResource(id);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(chatList.get(position));
            }
        });

        holder.decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Driver Rejected", Toast.LENGTH_SHORT).show();
                chatList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, chatList.size());
            }
        });

        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm = new Intent(context, ConfirmTripActivity.class);
                Bundle driverInfo = new Bundle();
                ChatItem d = chatList.get(position);
                driverInfo.putString("name", d.name);
                driverInfo.putString("pickup", d.pickup);
                driverInfo.putString("dest", d.dest);
                driverInfo.putString("dandt", d.dandt);
                driverInfo.putString("cost", d.cost);
                confirm.putExtras(driverInfo);
                context.startActivity(confirm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (chatList != null)? chatList.size(): 0;
    }
}
