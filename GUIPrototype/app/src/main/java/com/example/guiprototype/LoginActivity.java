package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private Button submitButton;
    //public String message;
    private Intent intent;
    private TextView textView;
    private EditText editText;
    private Switch switch1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    private String text;
    private Boolean switchOnOff;

    /*
    public static SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;
    public static final int PREFERENCE_MODE_PRIVATE = 0;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //intent = new Intent(this, MainActivity.class);

        textView = (TextView) findViewById(R.id.UsernameText);
        editText = (EditText) findViewById(R.id.edit_username_text);
        submitButton = (Button) findViewById(R.id.submitButton);
        switch1 = (Switch) findViewById(R.id.switchy);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*message = sendMessage();

                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                 */
                textView.setText(editText.getText().toString());
                saveUsernameData();
                openMainActivity();
            }
        });

        loadUsernameData();
        updateViews();
    }



    /** Called when the user taps the Submit button */
    /*
    public String sendMessage() {
        //Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_username_text);
        String myMessage = editText.getText().toString();
        return myMessage;

        //Player player = new Player(message);
        //Controller.saveData();

        //preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        //preferenceEditor = preferenceSettings.edit();
        //preferenceEditor.putString("username", message);
        //preferenceEditor.commit();

        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
     */


    public void saveUsernameData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }

    public void loadUsernameData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updateViews() {
        textView.setText(text);
        switch1.setChecked(switchOnOff);
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
