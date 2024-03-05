package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Messages extends Fragment implements SelectListener {
    RecyclerView recyclerView;
    static List<ChatItem> chatList = new ArrayList<>();
    static List<String> chatNames = new ArrayList<>();
    CustomAdapter customAdapter;

    public Messages() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        displayItems();
        if (recyclerView.getAdapter().getItemCount() == 0)
            Toast.makeText(getContext(), "No Drivers Selected", Toast.LENGTH_SHORT).show();

        return view;
    }

    private void displayItems() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 1));
        customAdapter = new CustomAdapter(this.getActivity(), chatList, this);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void onItemClicked(ChatItem chatItem) {
        Intent i = new Intent(this.getActivity(), ChatActivity.class);
        Bundle info = new Bundle();
        info.putString("Name", chatItem.name);
        info.putString("ImgResource", chatItem.imgResource);
        i.putExtras(info);
        startActivity(i);
    }
}