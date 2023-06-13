package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.model.Score;

import java.util.ArrayList;
import java.util.List;


public class Result extends AppCompatActivity {

    private List previousScores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        AppCompatButton start_new_quiz = findViewById(R.id.startNewQuiz);
        TextView correctAnswers = findViewById(R.id.correctAnswers);
        TextView wrongAnswers = findViewById(R.id.wrongAnswers);
        TextView congratsText = findViewById(R.id.congratsText);

        CharSequence name = getIntent().getCharSequenceExtra("name");
        congratsText.setText("Συγχαρητήρια " + name);

        int numberOfCorrectAnswers = getIntent().getIntExtra("correct",0);
        int numberOfWrongAnswers = getIntent().getIntExtra("incorrect",0);



        correctAnswers.setText("Correct answers are "+String.valueOf(numberOfCorrectAnswers));
        wrongAnswers.setText("Wrong answers are "+String.valueOf(numberOfWrongAnswers));


        switch (previousScores.size())       {
            case 0:
                break;

            case 1:
                //...

            case 2:
                //...

            case 3:
                //...

            case 4:
                //...

        }

        if (previousScores.size()>=5) {
            //Print  the scores "previousScores.get(previousScores.size() -5);" to "previousScores.get(previousScores.size());"
        }


        previousScores.add(new Score(numberOfCorrectAnswers));
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
