package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class AddSetActivityDL extends AppCompatActivity {

    public static final String DL_SETS_MESSAGE = "com.example.myfirstapp.MESSAGE";

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

        //numReps = Integer.parseInt(editRepsText.getText().toString());
        //myWeight = Double.parseDouble(editWeightText.getText().toString());

        String message = "Set: " + editRepsText.getText().toString() +
                " Reps @ " + editWeightText.getText().toString() + " lbs";

        intent.putExtra(DL_SETS_MESSAGE, message);
        startActivity(intent);
    }
}
