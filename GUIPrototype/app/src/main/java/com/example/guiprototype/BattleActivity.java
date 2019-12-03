package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.FileWriter;
import java.io.IOException;
import driver.*;
import com.WOPackage.FitWarriors.UnityPlayerActivity;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
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
