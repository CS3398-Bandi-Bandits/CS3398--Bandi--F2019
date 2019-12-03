

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

public class Pedometer extends AppCompatActivity implements SensorEventListener {

    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor counter;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int expSteps;
    private int lastKnownSteps;
    private int stepsSinceBoot;
    private int firstTimeCounter;
    private int firstSteps;
    private boolean firstTimeUser;
    private boolean firstIteration;


    private TextView TvSteps;

    private Button BtnStart;
    private Button BtnStop;
    private Button Save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        TvSteps = (TextView)findViewById(R.id.tv_steps);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        counter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
       /* simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);*/

       lastKnownSteps = Controller.player.getLastKnownSteps();

       firstTimeUser = Controller.player.isFirstPedometer();

       firstIteration = true;

        TvSteps = (TextView) findViewById(R.id.tv_steps);
    //    BtnStart = (Button) findViewById(R.id.btn_start);
  //      BtnStop = (Button) findViewById(R.id.btn_stop);
        Save = (Button) findViewById(R.id.viewXP);

        // always listen for steps
        sensorManager.registerListener(Pedometer.this, counter, SensorManager.SENSOR_DELAY_UI);
     /*   BtnStart.setOnClickListener(new android.view.View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                sensorManager.registerListener(Pedometer.this, counter, SensorManager.SENSOR_DELAY_FASTEST);
            }
        });
    */

       /* BtnStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                //expSteps = 20000; // testing
                sensorManager.unregisterListener(Pedometer.this);
            }
        });
*/


        Save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                // send data
                try {

                    Skill skill = Controller.player.getSpeedSkill();
                    Controller.player.setLastKnownSteps(stepsSinceBoot);
                    Controller.player.setFirstPedometer(false);
                    Controller.trainingMode(skill, expSteps);
                    expSteps = 0;


                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();
            }
        });

    }

    public void openTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {

            stepsSinceBoot = (int) event.values[0];

            if (firstTimeUser){
                if (firstIteration){
                    firstSteps = stepsSinceBoot;
                    TvSteps.setText("0");
                    firstIteration = false;
                }else
                {
                    firstTimeCounter = stepsSinceBoot - firstSteps;
                    TvSteps.setText(Integer.toString(firstTimeCounter));
                }
            }

            expSteps = stepsSinceBoot - lastKnownSteps;

            TvSteps.setText(Integer.toString(expSteps));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
