package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import driver.*;

public class StatsActivity extends AppCompatActivity {

    private TextView stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            Controller.createPlayer("user");
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        stats = (TextView) findViewById(R.id.textViewStats);
        stats.setText("");
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
