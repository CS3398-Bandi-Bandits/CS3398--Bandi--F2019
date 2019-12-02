package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.WOPackage.FitWarriors.UnityPlayerActivity;

import java.io.FileWriter;
import java.io.IOException;
import driver.*;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        //openBattle();
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }
//
//    public void openBattle() {
//        Intent intent = new Intent(this, UnityPlayerActivity.class);
//        startActivity(intent);
//
//    }
}
