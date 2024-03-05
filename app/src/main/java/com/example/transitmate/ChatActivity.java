package com.example.transitmate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    ImageView textImg;
    TextView textName, msg1, msg2, msg3;
    Bundle textInfo;
    Context context;
    ImageButton backButton, sendButton, declineButton, confirmButton;
    EditText msgBox;
    int msgCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        textName = (TextView) findViewById(R.id.textName);
        textImg = (ImageView) findViewById(R.id.textImg);
        backButton = (ImageButton) findViewById(R.id.backButtonChat);
        sendButton = (ImageButton) findViewById(R.id.sendButton);
        declineButton = (ImageButton) findViewById(R.id.declineB);
        confirmButton = (ImageButton) findViewById(R.id.confirmB);
        msgBox = (EditText) findViewById(R.id.messageBox);
        msg1 = (TextView) findViewById(R.id.msg1);
        msg2 = (TextView) findViewById(R.id.msg2);
        msg3 = (TextView) findViewById(R.id.msg3);
        textInfo = getIntent().getExtras();
        msgCount = 0;

        Intent backToMessages = new Intent(ChatActivity.this, MainActivity.class);
        Bundle info = new Bundle();
        info.putString("fragment", "messages");
        backToMessages.putExtras(info);

        String name = textInfo.getString("Name", "No Name");
        String img = textInfo.getString("ImgResource", "profile_icon");
        String pickup = textInfo.getString("Origin");
        String dest = textInfo.getString("Dest");
        String dandt = textInfo.getString("DandT");
        String cost = textInfo.getString("Cost");

        context = this.getApplicationContext();

        textName.setText(name);
        textImg.setImageResource(context.getResources().getIdentifier("drawable/" + img, null, context.getPackageName()));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backToMessages);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = msgBox.getText().toString();
                if (msg.length() > 0) {
                    msgCount++;
                    if (msgCount == 1)  {
                        msg1.setText(msg);
                        msg1.setVisibility(View.VISIBLE);
                    }
                    else if (msgCount == 2) {
                        msg2.setText(msg);
                        msg2.setVisibility(View.VISIBLE);
                    }
                    else if (msgCount == 3) {
                        msg3.setText(msg);
                        msg3.setVisibility(View.VISIBLE);
                    }
                    msgBox.setText("");
                }
            }
        });

        declineButton.setOnClickListener(new View.OnClickListener() {
            int removeIndex = -1;
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Messages.chatNames.size(); i++) {
                    if (name.equals(Messages.chatNames.get(i))) {
                        removeIndex = i;
                    }
                }

                Messages.chatList.remove(removeIndex);
                Toast.makeText(context, "Driver Rejected", Toast.LENGTH_SHORT).show();
                startActivity(backToMessages);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmDriver = new Intent(ChatActivity.this, ConfirmTripActivity.class);
                Bundle driverInfo = new Bundle();
                driverInfo.putString("name", name);
                driverInfo.putString("pickup",pickup);
                driverInfo.putString("dest", dest);
                driverInfo.putString("dandt", dandt);
                driverInfo.putString("cost", cost);
                confirmDriver.putExtras(driverInfo);
                startActivity(confirmDriver);

            }
        });

    }

}