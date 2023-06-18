package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Categories extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        final Button history = findViewById(R.id.btn_history);
        final Button geography = findViewById(R.id.btn_geography);
        final Button logo = findViewById(R.id.btn_logo);
        final Button random = findViewById(R.id.btn_random);

        // listener for the category history that starts the QuizQuestion activity and
        // gives the value 1 and the string history , and to know the activity in which category he is
        history.setOnClickListener(view -> {
            Intent intent1;
            intent1 = new Intent(Categories.this,QuizQuestions.class);
            intent1.putExtra("Category",1);
            intent1.putExtra("name",getIntent().getCharSequenceExtra("name"));
            startActivity(intent1);
            //System.out.println("ok after");
        });

        // listener for the category geography that starts the QuizQuestion activity and
        // gives the value 2 and the string geography , and to know the activity in which category he is
        geography.setOnClickListener(view -> {
            Intent intent2;
            intent2 = new Intent(Categories.this,QuizQuestions.class);
            intent2.putExtra("Category",2);
            intent2.putExtra("name",getIntent().getCharSequenceExtra("name"));
            startActivity(intent2);
        });

        // listener for the Logo Quiz history that starts the QuizLogos activity and
        // gives the value 3 and the string logo , and to know the activity in which category he is
        logo.setOnClickListener(view -> {
            Intent intent3;
            intent3 = new Intent(Categories.this,QuizLogos.class);
            intent3.putExtra("Category",3);
            intent3.putExtra("name",getIntent().getCharSequenceExtra("name"));
            startActivity(intent3);
        });

        // listener for the category random questions that starts the QuizQuestion activity and
        // gives the value 4 and the string random questions , and to know the activity in which category he is
        random.setOnClickListener(view -> {
            Intent intent4;
            intent4 = new Intent(Categories.this,QuizQuestions.class);
            intent4.putExtra("Category",4);
            intent4.putExtra("name",getIntent().getCharSequenceExtra("name"));
            startActivity(intent4);
        });
    }
}