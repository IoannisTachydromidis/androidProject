package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Categories extends AppCompatActivity {

    private int selectedCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        final Button history = findViewById(R.id.btn_history);
        final Button geography = findViewById(R.id.btn_geography);
        final Button logo = findViewById(R.id.btn_logo);
        final Button random = findViewById(R.id.btn_random);


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1;
                intent1 = new Intent(Categories.this,QuizQuestions.class);
                intent1.putExtra("Category",1);
                startActivity(intent1);
                //System.out.println("ok after");
            }
        });

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ok here");
                Intent intent2;
                intent2 = new Intent(Categories.this,QuizQuestions.class);
                intent2.putExtra("Category",2);
                startActivity(intent2);
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3;
                intent3 = new Intent(Categories.this,QuizLogos.class);
                intent3.putExtra("Category",3);
                startActivity(intent3);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4;
                intent4 = new Intent(Categories.this,QuizQuestions.class);
                intent4.putExtra("Category",4);
                startActivity(intent4);
            }
        });
    }
}