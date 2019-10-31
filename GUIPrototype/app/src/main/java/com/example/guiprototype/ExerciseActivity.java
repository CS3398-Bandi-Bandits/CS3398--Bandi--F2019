package com.example.guiprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import WOPackage.Exercise;
import WOPackage.WorkoutLog;
import driver.Controller;
import driver.Player;
import driver.Skill;

public class ExerciseActivity extends AppCompatActivity {

    public static final int ADD_SET_REQUEST = 3;
    public static final String REPS_MESSAGE = "com.example.guiprototype.ExerciseActivity.reps";
    public static final String WEIGHT_MESSAGE = "com.example.guiprototype.ExerciseActivity.weight";
    public static final String BENCH_PRESS = "Bench Press";
    public static final String DEADLIFT = "Deadlift";
    public static final String SQUAT = "Squats";
    private Exercise currentEx;
    private String exerciseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.exerciseTextView);

        exerciseName = intent.getStringExtra(TrainingActivity.EXERCISE_EXTRA);

        Controller.player.getLog().createExercise(exerciseName);

        currentEx = Controller.player.getLog().getCurrent();

        textView.setText(exerciseName);

        publishSets(Controller.player.getLog().getMatch(exerciseName));

    }

    public void openAddSetActivity(View view){

        Intent intent = new Intent(this, AddSetActivity.class);
        startActivityForResult(intent,ADD_SET_REQUEST);

    }

    public void saveExercise(View view){
        try{
            if (currentEx.getSets().isEmpty()){
                Exercise oldExercise = Controller.player.getLog().getMatch(currentEx.getName());
                publishSets(oldExercise);
            }
            else{
                Controller.player.getLog().setCurrent(currentEx);
                Controller.player.getLog().logExercise();
                int xpTotal = Controller.player.getLog().getTotalExp();
                switch (exerciseName) {
                    case BENCH_PRESS:
                        String message = "You gained " + xpTotal + " experience in Strength!";
                        Skill skill = Controller.player.getStrengthSkill();
                        Controller.trainingMode(skill, xpTotal);
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        break;
                    case DEADLIFT:
                        message = "You gained " + xpTotal + " experience in Strength!";
                        Skill dlSkill = Controller.player.getStrengthSkill();
                        //Skill hp = Controller.player.getHitPointsSkill();
                        //Controller.player.trainSkill(skill, xpTotal);
                        Controller.trainingMode(dlSkill, xpTotal);
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    default:
                        message = "You gained " + xpTotal + " experience in Defense!";
                        Skill defSkill = Controller.player.getDefenceSkill();
                        Controller.trainingMode(defSkill, xpTotal);
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    break;
                }
            }

            saveUserData(Controller.player);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this,TrainingActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case ADD_SET_REQUEST:
                if(resultCode == RESULT_OK) {
                    int reps = data.getIntExtra(REPS_MESSAGE, 5);
                    double weight = data.getDoubleExtra(WEIGHT_MESSAGE, 100.00);
                    attachSet(reps, weight);
                    publishSets(currentEx);
                }
        }

    }

    public void attachSet(int reps, double weight){
        currentEx.addSet(reps,weight);
    }

    public void publishSets(Exercise exercise){
        TextView setDataView = findViewById(R.id.exerciseDataTextView);
        String setData = exercise.printExercise();
        setDataView.setText(setData);
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

