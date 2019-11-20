package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
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
        stats.setText("");
        HashMap<String, String> statsMap = Controller.playerStats();

        for (Map.Entry<String, String> entry : statsMap.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            stats.append(key + ": " + val + "\n");
        }
    }
}
