package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import driver.Player;

public class SettingsActivity extends AppCompatActivity {

    private EditText editText;
    private Button submitButton;
    private Button logoutButton;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editText = (EditText) findViewById(R.id.change_username_text);
        submitButton = (Button) findViewById(R.id.submitChangeBtn);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString();
                player.setUsername(username);
                openMainActivity();
            }
        });

        logoutButton = (Button) findViewById(R.id.Button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }
}
