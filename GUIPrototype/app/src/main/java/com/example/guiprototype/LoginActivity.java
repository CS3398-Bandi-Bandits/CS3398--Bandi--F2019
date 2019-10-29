package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.*;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

import WOPackage.WorkoutLog;
import driver.*;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private Button submitButton;
   // public String message;
    private Intent intent;
    private TextView textView;
    private EditText editText;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //intent = new Intent(this, MainActivity.class);

        textView = (TextView) findViewById(R.id.UsernameText);
        editText = (EditText) findViewById(R.id.edit_username_text);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*message = sendMessage();

                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                 */
//                textView.setText("user");

                try {
                    String name = editText.getText().toString();
                    Player player = new Player(name);
                    WorkoutLog log = new WorkoutLog();
                    Controller.player = player;
                    Controller.setLog(log);
                    saveUserData(player);
                    saveUserWOLog(player.getUsername(),Controller.returnLog());
                    Controller.saveData();
                    Controller.saveWOData(player.getUsername());


                } catch(IOException e) {
                    e.printStackTrace();
                }
                /*catch(ClassNotFoundException c) {
                    c.printStackTrace();
                }*/
                openMainActivity();
            }

        });
    }



    /** Called when the user taps the Submit button */
    /*
    public String sendMessage() {
        //Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_username_text);
        String myMessage = editText.getText().toString();
        return myMessage;

        //Player player = new Player(message);
        //Controller.saveData();

        //preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        //preferenceEditor = preferenceSettings.edit();
        //preferenceEditor.putString("username", message);
        //preferenceEditor.commit();

        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
     */

    public void saveUserWOLog(String name, WorkoutLog l){

        try {
            FileOutputStream fileStream  = openFileOutput(name+"WO.dat", MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(l);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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



        /*SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(player.getStrengthSkill());
        skills.add(player.getDefenceSkill());
        skills.add(player.getSpeedSkill());
        skills.add(player.getHitPointsSkill());

        RuntimeTypeAdapterFactory<Skill> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Skill.class, "type")
                .registerSubtype(Defence.class, "defence")
                .registerSubtype(Strength.class, "strength")
                .registerSubtype(Hitpoints.class, "hitpoints")
                .registerSubtype(Speed.class, "speed");

        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

        //Gson gson = new Gson();
        String json = gson.toJson(skills);
        editor.putString("MyObject", json);
        editor.commit();

        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();*/
    }



    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
