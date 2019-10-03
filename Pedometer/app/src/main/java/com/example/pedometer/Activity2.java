package com.example.pedometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textView;
    private static final String TEXT_NUM_STEPS1 = "Current XP = ";
    GetSet taco = new GetSet();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView = (TextView) findViewById(R.id.TextXp);
        double XP = getIntent().getIntExtra("Xp",0);

        XP = XP / 2;



        textView.setText(TEXT_NUM_STEPS1 + XP);


    }
}
