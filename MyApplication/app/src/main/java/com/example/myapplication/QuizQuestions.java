package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizQuestions extends AppCompatActivity {
    private TextView question_number;
    private TextView question;

    private Button option1,option2,option3,option4;
    private AppCompatButton btn_next;
    final String category = getIntent().getStringExtra("Category");

    List<Questions> optionList = Database.getOptionsFromDB(category);
    List<String> questionsList = Database.getQuestionsFromDB(category);

    private String userSelectedOption = "";
    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        question = findViewById(R.id.question);
        question_number = findViewById(R.id.questions_number);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        btn_next = findViewById(R.id.btn_next);

        question_number.setText( String.valueOf(currentPosition+1) +"/10");
        question.setText(questionsList.get(currentPosition));
        option1.setText(optionList.get(currentPosition).getOption1().toString());
        option2.setText(optionList.get(currentPosition).getOption2().toString());
        option3.setText(optionList.get(currentPosition).getOption3().toString());
        option4.setText(optionList.get(currentPosition).getOption4().toString());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption.isEmpty()){

                    userSelectedOption = option1.getText().toString();

                    option1.setTextColor(Color.WHITE);

                    optionList.get(currentPosition).setUserSelectedAnswer(userSelectedOption);
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption.isEmpty()){

                    userSelectedOption = option2.getText().toString();

                    option2.setTextColor(Color.WHITE);

                    optionList.get(currentPosition).setUserSelectedAnswer(userSelectedOption);
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption.isEmpty()){

                    userSelectedOption = option3.getText().toString();

                    option3.setTextColor(Color.WHITE);

                    optionList.get(currentPosition).setUserSelectedAnswer(userSelectedOption);
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userSelectedOption.isEmpty()){

                    userSelectedOption = option4.getText().toString();

                    option4.setTextColor(Color.WHITE);

                    optionList.get(currentPosition).setUserSelectedAnswer(userSelectedOption);
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userSelectedOption.isEmpty()){
                    Toast.makeText(QuizQuestions.this,"Please select an option",Toast.LENGTH_SHORT);
                }
                else {
                    currentPosition++;
                    nextQuestions();
                }
            }
        });

    }

    private void nextQuestions(){
        question_number.setText( String.valueOf(currentPosition) +"/10");
        question.setText(questionsList.get(currentPosition+1));
        option1.setText(optionList.get(currentPosition).getOption1().toString());
        option2.setText(optionList.get(currentPosition).getOption2().toString());
        option3.setText(optionList.get(currentPosition).getOption3().toString());
        option4.setText(optionList.get(currentPosition).getOption4().toString());
    }
}