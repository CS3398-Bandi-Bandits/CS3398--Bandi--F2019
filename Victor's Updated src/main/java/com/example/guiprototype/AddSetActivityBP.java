package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class AddSetActivityBP extends AppCompatActivity {

    public static final String BP_SETS_MESSAGE = "com.example.myfirstapp.MESSAGE";
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

        //numReps = Integer.parseInt(editRepsText.getText().toString());
        //myWeight = Double.parseDouble(editWeightText.getText().toString());

        String message = "Set: " + editRepsText.getText().toString() +
                         " Reps @ " + editWeightText.getText().toString() + " lbs";

        intent.putExtra(BP_SETS_MESSAGE, message);
        startActivity(intent);
    }
}
