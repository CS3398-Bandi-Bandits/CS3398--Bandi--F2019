package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import WOPackage.Exercise;
import driver.Controller;

public class ViewLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);
        ListView mListView = (ListView) findViewById(R.id.listView);

        ArrayList<Exercise> log = Controller.player.getLog().getBackLog();

        ArrayList<ListViewBlock> listViewBlocks = new ArrayList<>();

        for (Exercise e:log) {


            listViewBlocks.add(new ListViewBlock(e.getName(),e.toString()));

        }

        ExerciseListAdapter adapter = new ExerciseListAdapter(this,R.layout.adapter_view_layout,listViewBlocks);
        mListView.setAdapter(adapter);

    }
}
