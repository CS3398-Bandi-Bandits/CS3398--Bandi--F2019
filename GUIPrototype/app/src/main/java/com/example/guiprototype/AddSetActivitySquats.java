package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import driver.*;
import WOPackage.*;

public class AddSetActivitySquats extends AppCompatActivity {

    public static final String SQUATS_SETS_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public WorkoutLog log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set_squats);
    }

    /** Called when the user taps the Save button */
    public void sendSquatsMessage(View view) throws IOException {
        Intent intent = new Intent(this, SquatsActivity.class);
        EditText editRepsText = (EditText) findViewById(R.id.repsEditTextInSquats);
        EditText editWeightText = (EditText) findViewById(R.id.weightEditTextInSquats);

        //numReps = Integer.parseInt(editRepsText.getText().toString());
        //myWeight = Double.parseDouble(editWeightText.getText().toString());

      //  String message = "Set: " + editRepsText.getText().toString() +
       //         " Reps @ " + editWeightText.getText().toString() + " lbs";

        //intent.putExtra(SQUATS_SETS_MESSAGE, message);


        /////////
        int reps = Integer.parseInt(editRepsText.getText().toString());
        double weight = Double.parseDouble(editWeightText.getText().toString());

        log = Controller.log;
        log.createExercise("squat");

        log.current.addSet(reps, weight);
        log.logExercise();
        int xpTotal = log.getTotalExp();


        Skill skill = Controller.player.getDefenceSkill();
        Controller.trainingMode(skill, xpTotal);

        String message = "You gained " + xpTotal + " experience in Defence!";

        intent.putExtra(SQUATS_SETS_MESSAGE, message);
        /////////

        startActivity(intent);
    }
}
