package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;

import WOPackage.WorkoutLog;
import driver.Controller;
import driver.Skill;

public class AddSetActivityBP extends AppCompatActivity {

    public static final String BP_SETS_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static WorkoutLog log;
    //public static int numReps;
    //public static double myWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set_bp);
    }

    /** Called when the user taps the Save button */
    public void sendRepsMessage(View view) throws IOException {
        Intent intent = new Intent(this, BenchPressActivity.class);
        EditText editRepsText = (EditText) findViewById(R.id.repsEditText);
        EditText editWeightText = (EditText) findViewById(R.id.weightEditText);

        /////////
        int reps = Integer.parseInt(editRepsText.getText().toString());
        double weight = Double.parseDouble(editWeightText.getText().toString());

        log = Controller.log;
        log.createExercise("Bench Press");

        log.current.addSet(reps, weight);
        log.logExercise();
        int xpTotal = log.getTotalExp();


        Skill skill = Controller.player.getStrengthSkill();
        Controller.trainingMode(skill, xpTotal);

        String message = "You gained " + xpTotal + " experience in Strength!";

        Toast toast = Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.show();

        /////////

        finish();
    }
}
