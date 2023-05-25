package com.example.myapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.provider.QuestionsProvider;

import java.util.List;

public class QuizQuestions extends AppCompatActivity {
    private TextView question_number;
    private TextView question;

    private Button option1,option2,option3,option4;
    private AppCompatButton btn_next;

//    private int category = 1;
    private int userSelectedOption = 0;
    private int currentPosition = 0;

    //Use this QuestionProvider to retrieve 10 questions for a given category.
    //The method that retrieves the questions is called getQuestions.
    //The type of the parameter is int and it represents a category.
    //The return value is a List of type QuestionDto.
    //Note that QuestionDto has ONLY getters, with only exception being the userSelectedOption
    private final QuestionsProvider provider = new QuestionsProvider(this);
    List<QuestionDto> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
       // System.out.println("ok finish");

        int category = getIntent().getIntExtra("Category",0);

        questions =  provider.getQuestions(category);

        question = findViewById(R.id.question);
        question_number = findViewById(R.id.questions_number);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        btn_next = findViewById(R.id.btn_next);


        question_number.setText( String.valueOf(currentPosition+1) +"/10");

        question.setText(questions.get(1).getQuestion());
        option1.setText(questions.get(0).getOption1().toString());
        option2.setText(questions.get(0).getOption2().toString());
        option3.setText(questions.get(0).getOption3().toString());
        option4.setText(questions.get(0).getOption4().toString());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption == 0){
                    option1.setBackgroundResource(R.drawable.ic_launcher_foreground);
                    userSelectedOption = categorytoInt(option1.getText().toString());
                    questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption == 0){
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    userSelectedOption = categorytoInt(option2.getText().toString());
                    questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption==0){
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    userSelectedOption = categorytoInt(option3.getText().toString());
                    questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption == 0){
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    userSelectedOption = categorytoInt(option4.getText().toString());
                    questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userSelectedOption == 0){
                    Toast.makeText(QuizQuestions.this,"Please select an option",Toast.LENGTH_SHORT);
                }
                else {
                    System.out.println(questions.get(currentPosition).getUserSelectedOption());
                    System.out.println(questions.get(currentPosition).getAnswer());
                    nextQuestions();
                }
            }
        });

    }

    private void nextQuestions(){
        currentPosition++;

        if( (currentPosition+1) == questions.size()){
            btn_next.setText("Submit Quiz");
        }
        if( currentPosition < questions.size()){
            userSelectedOption = 0;


            option2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
            option3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
            option4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));

            question_number.setText( String.valueOf(currentPosition+1) +"/10");
            question.setText(questions.get(currentPosition).getQuestion());
            option1.setText(questions.get(currentPosition).getOption1().toString());
            option2.setText(questions.get(currentPosition).getOption2().toString());
            option3.setText(questions.get(currentPosition).getOption3().toString());
            option4.setText(questions.get(currentPosition).getOption4().toString());
        }
        else{
            Intent intent = new Intent(QuizQuestions.this,Result.class);
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getIncorrectAnswers());
            startActivity(intent);
        }

    }

    private int categorytoInt(String category){
        switch (category){
            case "history":
                return 1;
            case "geography":
                return 2;
            case "logo":
                return 3;
            case "random":
                return 4;
        }
        return 1;
    }

    private int getCorrectAnswers(){
        int correctAnswers = 0;

        for(int i=0; i< questions.size(); i++){
            final int getUserSelectedAnswer = questions.get(i).getUserSelectedOption();
            final int getAnswer = questions.get(i).getAnswer();

            if(getUserSelectedAnswer == getAnswer){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers(){
        int incorrectAnswers = 0;

        for(int i=0; i< questions.size(); i++){
            final int getUserSelectedAnswer = questions.get(i).getUserSelectedOption();
            final int getAnswer = questions.get(i).getAnswer();

            if(getUserSelectedAnswer != getAnswer){
                incorrectAnswers++;
            }
        }
        return incorrectAnswers;
    }
}