package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Categories extends AppCompatActivity {

    private String selectedCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        final Button history = findViewById(R.id.btn_history);
        final Button geography = findViewById(R.id.btn_geography);
        final Button logo = findViewById(R.id.btn_logo);
        final Button random = findViewById(R.id.btn_random);

        final Button startBtn = findViewById(R.id.startButton);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedCategory = "history";
                Intent intent = new Intent(Categories.this, QuizQuestions.class);
                intent.putExtra("Category",selectedCategory);
                startActivity(intent);
            }
        });
    }
}