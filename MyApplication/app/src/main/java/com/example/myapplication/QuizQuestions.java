package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

        //στην μεταβλητή category τοποθετείτε ένα νούμερο απο το 1-4 που αναπαριστά την κατηγορία
        //που έχει επιλέξει ο χρήστης(1-ιστορία,2-γεωγραφία,3-logos,4-τυχαίες ερωτήσεις)
        int category = getIntent().getIntExtra("Category",0);

        // Η questions είναι μία λίστα στην οποία αποθηκεύονται τα δεδομένα απο την Βάση
        // με παράμετρο την κατηγορία που έδωσε ο χρήστης
        questions =  provider.getQuestions(category);

        question = findViewById(R.id.question);
        question_number = findViewById(R.id.questions_number);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        btn_next = findViewById(R.id.btn_next);

        // firstly, we determine the previous questions and possible answers from our database with the help of questions
        question_number.setText(currentPosition + 1 +"/10");

        question.setText(questions.get(0).getQuestion());
        option1.setText(questions.get(0).getOption1());
        option2.setText(questions.get(0).getOption2());
        option3.setText(questions.get(0).getOption3());
        option4.setText(questions.get(0).getOption4());

        option1.setOnClickListener(view -> {

                //option1.setBackgroundResource(R.drawable.ic_launcher_foreground);
                userSelectedOption = 1;

                questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });
        option2.setOnClickListener(view -> {

                //option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                userSelectedOption = 2;
                questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });
        option3.setOnClickListener(view -> {

            if(userSelectedOption==0){
               // option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                userSelectedOption = 3;
                questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
            }
        });
        option4.setOnClickListener(view -> {

               // option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                userSelectedOption = 4;
                questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });

        btn_next.setOnClickListener(view -> {
            if(userSelectedOption == 0){
                Toast.makeText(QuizQuestions.this,"Please select an option",Toast.LENGTH_SHORT).show();
            }
            else {
                System.out.println(questions.get(currentPosition).getUserSelectedOption());
                System.out.println(questions.get(currentPosition).getAnswer());
                nextQuestions();
            }
        });

    }
    // Η μέθοδος nextQuestions ενημερώνει τις τιμές των ερωτήσεων ,απαντήσεων καθώς και της τρέχουσας θέσης
    // Αν έχει φτάσει στο τέλος δημιουργείται ένα Intent για την εκκίνηση της Κλάσης Result περνόντας σε αυτήν
    // τις σωστές και λάθος απαντήσεις και το όνομα του χρήστη
    private void nextQuestions(){
        currentPosition++;

        if( (currentPosition+1) == questions.size()){
            btn_next.setText("Υποβολή Quiz");
        }
        if( currentPosition < questions.size()){
            userSelectedOption = 0;

            question_number.setText(currentPosition + 1 +"/10");
            question.setText(questions.get(currentPosition).getQuestion());
            option1.setText(questions.get(currentPosition).getOption1());
            option2.setText(questions.get(currentPosition).getOption2());
            option3.setText(questions.get(currentPosition).getOption3());
            option4.setText(questions.get(currentPosition).getOption4());
        }
        else{
            Intent intent = new Intent(QuizQuestions.this,Result.class);
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getIncorrectAnswers());
            intent.putExtra("name",getIntent().getCharSequenceExtra("name"));
            startActivity(intent);
        }

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