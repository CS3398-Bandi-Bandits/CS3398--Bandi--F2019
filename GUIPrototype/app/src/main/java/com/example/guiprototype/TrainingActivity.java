package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import driver.*;

public class TrainingActivity extends AppCompatActivity {

    public static final String EXERCISE_EXTRA = "com.example.guiPrototype.exerciseName";
    private Button pedometerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

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
            publishCSV(Controller.player);
            FileOutputStream fileStream = openFileOutput("database.dat", MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(player);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void publishCSV(Player player){

        try {
            Character delimiter = '\n';
            FileWriter fileWriter = new FileWriter("stats.txt");
            fileWriter.write(player.getUsername()+delimiter);
            fileWriter.write(player.getSpeedSkill()+delimiter.toString());
            fileWriter.write(player.getHitPointsSkill()+delimiter.toString());
            fileWriter.write(player.getDefenceSkill()+delimiter.toString());
            fileWriter.write(player.getStrengthSkill()+delimiter.toString());
            fileWriter.write(player.getCombatLevel()+delimiter.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
