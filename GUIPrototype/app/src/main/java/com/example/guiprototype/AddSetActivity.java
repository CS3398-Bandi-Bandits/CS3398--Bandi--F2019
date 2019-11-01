package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set);
    }

    public void submitNumbers(View view){

        EditText editText = findViewById(R.id.repsEditText);
        int reps = Integer.parseInt(editText.getText().toString());
        editText = findViewById(R.id.weightEditText);
        double weight = Double.parseDouble(editText.getText().toString());

        Intent intent = new Intent();

        intent.putExtra(ExerciseActivity.REPS_MESSAGE,reps);
        intent.putExtra(ExerciseActivity.WEIGHT_MESSAGE,weight);
        setResult(RESULT_OK,intent);
        finish();
    }
}
