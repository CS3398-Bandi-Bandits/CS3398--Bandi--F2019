package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BenchPressActivity extends AppCompatActivity {

    private Button addSetButton;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_press);



        addSetButton = (Button) findViewById(R.id.addSetButtoninBP);
        addSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddSetBPActivity();
            }
        });

        saveButton = (Button) findViewById(R.id.saveButtonInBP);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingActivity();
            }
        });

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(AddSetActivityBP.BP_SETS_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.benchDataTextView);
        textView.setText(message);
    }

    public void openAddSetBPActivity() {
        Intent intent = new Intent(this, AddSetActivityBP.class);
        startActivity(intent);
    }

    public void openTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }
}
