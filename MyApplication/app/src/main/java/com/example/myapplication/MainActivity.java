package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText objEditTextName;
    private Button greetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetButton = findViewById(R.id.greet_button);
        objEditTextName = findViewById(R.id.editTextText);
        objEditTextName.setHint("Name");

        if (savedInstanceState != null){
//Retrieve data from the Bundle (other methods include getInt(), getBoolean() etc)
            CharSequence userText = savedInstanceState.getCharSequence("savedUserText");
//Restore the dynamic state of the UI
            objEditTextName.setText(userText);

        }
        else{
//Initialize the UI
            objEditTextName.setText("");
            objEditTextName.setHint("Name");
        }

        CharSequence nameText = objEditTextName.getText();
        // listener for the play button
        greetButton.setOnClickListener(v -> {
            // check if the user doesn't give name
            if( !nameText.toString().isEmpty() ){
                Intent intent = new Intent(MainActivity.this, Categories.class);
                intent.putExtra("name",nameText);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//Save data to the Bundle (other methods include putInt(), putBoolean() etc)
        CharSequence userText = objEditTextName.getText();
        outState.putCharSequence("savedUserText", userText);
    }
}
