package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import driver.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button statsButton;
    private Button trainButton;
    private Button battleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginActivity.preferenceSettings = getPreferences(LoginActivity.PREFERENCE_MODE_PRIVATE);

        String uName = LoginActivity.preferenceSettings.getString("username", "user");


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.UsernameText);
        textView.setText(uName);

        statsButton = (Button) findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatsActivity();
            }
        });

        trainButton = (Button) findViewById(R.id.trainButton);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingActivity();
            }
        });

        battleButton = (Button) findViewById(R.id.battleButton);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBattleActivity();
            }
        });

    }

    public void openStatsActivity() {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void openTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    public void openBattleActivity() {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

    /*public void sendStatsMessage(View view) throws IOException {
        Intent intent = new Intent(this, StatsActivity.class);

        HashMap<String, Integer> stats = Controller.playerStats();
        String message = "";
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            message = entry.getKey() + ": " + entry.getValue();
        }

        //Player player = new Player(message);
        //Controller.saveData();

        //intent.putExtra(EXTRA_MESSAGE_MAIN, message);
        startActivity(intent);
    }*/
}
