package com.example.transitmate;

public class ChatItem {

    String imgResource = "";
    String name = "";
    String pickup, dest, dandt, cost;

    public ChatItem(String name, String imgResource, String pickup, String dest, String dandt, String cost) {
        this.imgResource = imgResource;
        this.name = name;
        this.dest = dest;
        this.pickup = pickup;
        this.dandt = dandt;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}
