package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import WOPackage.WorkoutLog;
import driver.Controller;
import driver.Player;
import driver.Skill;

public class TrainingActivity extends AppCompatActivity {

    public static final String EXERCISE_EXTRA = "com.example.guiPrototype.exerciseName";
    private Button benchPressButton;
    private Button squatsButton;
    private Button deadliftButton;
    private Button pedometerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

       // Controller.createLog();
/*

        benchPressButton = (Button) findViewById(R.id.benchButton);
        benchPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBenchPressActivity();
            }
        });


        squatsButton = (Button) findViewById(R.id.squatsButton);
        squatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSquatsActivity();
            }
        });

        deadliftButton = (Button) findViewById(R.id.deadliftButton);
        deadliftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeadliftActivity();
            }
        });

      */

        pedometerButton = (Button) findViewById(R.id.pedoButton);
        pedometerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPedometerActivity();
            }
        });


//// ********** TRIES TO SAVE IT HERE!!!!!!
        try {
            saveUserData(Controller.player);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void openBenchPressActivity() {
        Intent intent = new Intent(this, BenchPressActivity.class);
        startActivity(intent);
    }

    public void openSquatsActivity() {
        Intent intent = new Intent(this, SquatsActivity.class);
        startActivity(intent);
    }

    public void openDeadliftActivity() {
        Intent intent = new Intent(this, DeadliftActivity.class);
        startActivity(intent);
    }

    public void openPedometerActivity(){
        Intent intent = new Intent(this, Pedometer.class);
        startActivity(intent);

    }

    public void openExerciseActivity(View view){
        Intent intent = new Intent(this, ExerciseActivity.class);
        TextView textView = (TextView)view;
        String exerciseName = textView.getText().toString();
        intent.putExtra(EXERCISE_EXTRA, exerciseName);
        startActivity(intent);
    }

    public void saveUserData(Player player) throws IOException {

        try {
            FileOutputStream fileStream = openFileOutput("database.dat", MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(player);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
