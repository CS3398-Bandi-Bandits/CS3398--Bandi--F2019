package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import driver.*;

public class Pedometer extends AppCompatActivity implements SensorEventListener, StepListener {

    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;

    private TextView TvSteps;

    private Button BtnStart;
    private Button BtnStop;
    private Button Save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        TvSteps = (TextView) findViewById(R.id.tv_steps);
        BtnStart = (Button) findViewById(R.id.btn_start);
        BtnStop = (Button) findViewById(R.id.btn_stop);
        Save = (Button) findViewById(R.id.viewXP);

        // always listen for steps
        sensorManager.registerListener(Pedometer.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

        BtnStart.setOnClickListener(new android.view.View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                sensorManager.registerListener(Pedometer.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
            }
        });


        BtnStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                //numSteps = 20000; // testing
                sensorManager.unregisterListener(Pedometer.this);
            }
        });

        Save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                // send data
                try {

                    Skill skill = Controller.player.getSpeedSkill();
                    Controller.trainingMode(skill, numSteps);
                    numSteps = 0;

                } catch (IOException e) {
                    e.printStackTrace();
                }

                openTrainingActivity();
            }
        });

    }

    public void openTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }
}
