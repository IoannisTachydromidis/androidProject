package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        AppCompatButton start_new_quiz = findViewById(R.id.startNewQuiz);
        TextView correctAnswers = findViewById(R.id.correctAnswers);
        TextView wrongAnswers = findViewById(R.id.wrongAnswers);

        int numberOfCorrectAnswers = getIntent().getIntExtra("correct",0);
        int numberOfWrongAnswers = getIntent().getIntExtra("incorrect",0);

        correctAnswers.setText("Correct answers are "+String.valueOf(numberOfCorrectAnswers));
        wrongAnswers.setText("Wrong answers are "+String.valueOf(numberOfWrongAnswers));

        start_new_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,Categories.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
