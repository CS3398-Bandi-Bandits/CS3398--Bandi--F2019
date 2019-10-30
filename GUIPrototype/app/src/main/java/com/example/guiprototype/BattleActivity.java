package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import driver.Controller;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Controller.exportStats();

    }
}
