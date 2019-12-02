package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import driver.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.WOPackage.FitWarriors.UnityPlayerActivity;

public class MainActivity extends AppCompatActivity {

    public static final int LOGIN_REQUEST = 1;
    private Button statsButton;
    private Button trainButton;
    private Button battleButton;
    private Button settingsButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.UsernameText);
        String[] files = fileList();

        try {
		// if account doesn't exist, create one
            if(!Controller.doesDatabaseExist(files)){
                openLoginActivity();
            }
		// otherwise, go to the main screen
            else {
                run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() throws ClassNotFoundException{

           try{ //Controller.getData();

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

               settingsButton = (Button) findViewById(R.id.settingsButton);
               settingsButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       openSettingsActivity();
                   }
               });

           } catch (IOException e) {
               e.printStackTrace();
           }
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
    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent,LOGIN_REQUEST);
    }


    public void getUserData() throws IOException, ClassNotFoundException {

       Player player;
        try {
            FileInputStream fileStream = openFileInput("database.dat");
            ObjectInputStream in = new ObjectInputStream(fileStream);
            player = (driver.Player)in.readObject();
            Controller.player = player;
            fileStream.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case LOGIN_REQUEST:
                if(resultCode == RESULT_OK)
                {
                    try {
                        String username = dataIntent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
                        establishPlayer(username);
                        run();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
                else
                    openLoginActivity();
        }
    }

    public void establishPlayer(String username){
        try{
            Player player = new Player(username);
            Controller.player = player;
            saveUserData(player);
            Controller.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUserData(Player player) throws IOException {

        try {
            FileOutputStream fileStream  = openFileOutput("database.dat", MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(player);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
