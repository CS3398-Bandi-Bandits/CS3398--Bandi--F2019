package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import driver.Controller;

public class StatsActivity extends AppCompatActivity {

    private TextView stats;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        userName = (TextView) findViewById(R.id.usernameText);
        userName.setText(Controller.player.getUsername());

        stats = (TextView) findViewById(R.id.textViewStats);
        stats.append("\n\n");
        HashMap<String, String> statsMap = Controller.playerStats();

        for (Map.Entry<String, String> entry : statsMap.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            stats.append(key + ": " + val + "\n");
        }



        /*
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_MAIN);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textViewStats);
        textView.setText(message);
        */
    }
}
