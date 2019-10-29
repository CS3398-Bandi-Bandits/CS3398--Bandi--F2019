package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import driver.*;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import static driver.Controller.doesDatabaseExist;

public class MainActivity extends AppCompatActivity {

    private Button statsButton;
    private Button trainButton;
    private Button battleButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.UsernameText);
        String[] files = fileList();


        try {
            if(Controller.doesDatabaseExist(files)) {
                //Controller.getData();

                getUserData();
                textView.setText(Controller.player.getUsername());

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

            /*String username = Controller.getPlayer().getUsername();
            String welcomeBack = "Welcome back, " + username + "!";

            TextView textView = findViewById(R.id.UsernameText);
            textView.setText(welcomeBack);*/

            /*Gson gson = new Gson();
            String json = sharedPreferences.getString("MyObject", "");
            Player player = gson.fromJson(json, Player.class);


            String username = Controller.getPlayer().getUsername();
            String welcomeBack = "Welcome back, " + username + "!";

            TextView textView = findViewById(R.id.UsernameText);
            textView.setText(welcomeBack);*/

                // otherwise, if the file DNE, go to the Login page and create a new user
            } else {
                //System.out.println("Please create an account.");

                //String name = getNewUsername();

                openLoginActivity();
                //Controller.saveData();

            }
        } catch(IOException e) {
           // e.getStackTrace();
            //System.exit(0);
        } catch(ClassNotFoundException c) {
           // c.getStackTrace();
           //System.exit(0);
        }



        //LoginActivity.preferenceSettings = getPreferences(LoginActivity.PREFERENCE_MODE_PRIVATE);

        //String uName = LoginActivity.preferenceSettings.getString("username", "user");

        /*
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.UsernameText);
        textView.setText(message);
         */


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
    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void getUserData() throws IOException, ClassNotFoundException {

       Player player;
        try {
            FileInputStream fileStream = openFileInput("database.dat");
            ObjectInputStream in = new ObjectInputStream(fileStream);
            player = (Player) in.readObject();
            Controller.player = player;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
