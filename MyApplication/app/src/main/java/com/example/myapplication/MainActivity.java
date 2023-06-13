package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private boolean nameEmpty = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button greetButton = findViewById(R.id.greet_button);
        EditText objEditTextName = findViewById(R.id.editTextText);
        //System.out.println("ok here");
        CharSequence nameText = objEditTextName.getText();
        if(nameText.equals(" "))
            nameEmpty = true;
        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameEmpty==false){
                    Intent intent = new Intent(MainActivity.this, Categories.class);
                    intent.putExtra("name",nameText);
                    startActivity(intent);
                }
            }
        });


    }
}
