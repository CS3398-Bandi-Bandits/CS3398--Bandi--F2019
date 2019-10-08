package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;

import driver.Controller;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        try {
            checkUser();
        } catch(IOException e) {
            e.getStackTrace();
        } catch(ClassNotFoundException c) {
            c.getStackTrace();
        }
    }

    public void checkUser() throws IOException, ClassNotFoundException {
        boolean exists = Controller.doesDatabaseExist();

        // if account exists, go straight to the main page
        if(exists == true) {
            Controller.getData();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            // otherwise, create a new user
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }


}
