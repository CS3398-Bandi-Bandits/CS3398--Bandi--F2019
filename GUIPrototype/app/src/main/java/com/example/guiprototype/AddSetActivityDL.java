package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import WOPackage.WorkoutLog;
import driver.Controller;
import driver.Skill;

public class AddSetActivityDL extends AppCompatActivity {

    public static final String DL_SETS_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static WorkoutLog log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set_dl);
    }

    /** Called when the user taps the Save button */
    public void sendDLMessage(View view) throws IOException {
        Intent intent = new Intent(this, DeadliftActivity.class);
        EditText editRepsText = (EditText) findViewById(R.id.repsEditTextInDL);
        EditText editWeightText = (EditText) findViewById(R.id.weightEditTextInDL);

        /////////
        int reps = Integer.parseInt(editRepsText.getText().toString());
        double weight = Double.parseDouble(editWeightText.getText().toString());

        log = Controller.log;
        log.createExercise("Deadlifts");

        log.current.addSet(reps, weight);
        log.logExercise();
        int xpTotal = log.getTotalExp();


        Skill skill = Controller.player.getStrengthSkill();
        //Skill hp = Controller.player.getHitPointsSkill();
        //Controller.player.trainSkill(skill, xpTotal);
        Controller.trainingMode(skill, xpTotal);

        String message = "You gained " + xpTotal + " experience in Strength!";

        intent.putExtra(DL_SETS_MESSAGE, message);
        /////////


        startActivity(intent);
    }
}
