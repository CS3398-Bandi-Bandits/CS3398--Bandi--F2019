package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import WOPackage.WorkoutLog;
import driver.Controller;
import driver.Skill;

public class TrainingActivity extends AppCompatActivity {

    private Button benchPressButton;
    private Button squatsButton;
    private Button deadliftButton;
    private Button pedometerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

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

        pedometerButton = (Button) findViewById(R.id.pedoButton);
        pedometerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPedometerActivity();
            }
        });
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

    }

    /*public void trainingData() throws IOException {
        Skill skill;
        WorkoutLog log = new WorkoutLog();

        ArrayList<String> options = log.getOptions();


        System.out.println("Select a workout:");
        for(int i = 0; i < options.size(); i++) {
            System.out.println(i+1 + ": " + options.get(i));
        }

        System.out.println();
        System.out.print("Enter selection: ");

        Scanner scan = new Scanner(System.in);
        int selected = scan.nextInt();
        String name;

        if(selected == 1) {
            name = "bench press";
        } else if(selected == 2) {
            name = "squat";
        } else {
            name = "dead-lift";
        }


        log.createExercise(name);
        System.out.println();

        System.out.print("Add reps: ");
        int reps = scan.nextInt();
        System.out.println();

        System.out.print("Add weight: ");
        double weight = scan.nextDouble();
        System.out.println();

        log.getCurrent().addSet(reps, weight);

        log.logExercise();
        int xpTotal = log.getTotalExp();


        if(log.getCurrent().getName().toLowerCase().equals("squat")) {
            skill = Controller.getPlayer().getDefenceSkill();
        } else {
            skill = Controller.getPlayer().getStrengthSkill();
        }



        Controller.trainingMode(skill, xpTotal);
        System.out.println();
        System.out.println("You gained " + xpTotal + " experience!");
        System.out.println();


    }*/
}
