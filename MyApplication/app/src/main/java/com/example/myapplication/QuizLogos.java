package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.provider.QuestionsProvider;

import java.util.HashMap;
import java.util.List;

public class QuizLogos extends AppCompatActivity {
    private TextView question_number;
    private ImageView logo;

    private Button option1, option2, option3, option4;
    private AppCompatButton btn_next;

    //    private int category = 1;
    private int userSelectedOption = 0;
    private int currentPosition = 0;

    private HashMap<String, Drawable> photos;

    // Use this QuestionProvider to retrieve 10 questions for a given category.
    // The method that retrieves the questions is called getQuestions.
    // The type of the parameter is int and it represents a category.
    // The return value is a List of type QuestionDto.
    // Note that QuestionDto has ONLY getters, with the only exception being the userSelectedOption
    private final QuestionsProvider provider = new QuestionsProvider(this);
    List<QuestionDto> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_logos);
        // System.out.println("ok finish");

        initializePhotos();

        int category = getIntent().getIntExtra("Category", 0);

        questions = provider.getQuestions(category);

        logo = findViewById(R.id.logo);
        question_number = findViewById(R.id.questions_number);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        btn_next = findViewById(R.id.btn_next);


        question_number.setText(currentPosition + 1 + "/10");

        logo.setImageDrawable(photos.get(questions.get(0).getQuestion()));
        option1.setText(questions.get(0).getOption1());
        option2.setText(questions.get(0).getOption2());
        option3.setText(questions.get(0).getOption3());
        option4.setText(questions.get(0).getOption4());

        option1.setOnClickListener(view -> {
            // Ο χρήστης επιλέγει την πρώτη επιλογή
            userSelectedOption = 1;
            questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });
        option2.setOnClickListener(view -> {
            // Ο χρήστης επιλέγει τη δεύτερη επιλογή
            userSelectedOption = 2;
            questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });
        option3.setOnClickListener(view -> {
            // Ο χρήστης επιλέγει την τρίτη επιλογή
            userSelectedOption = 3;
            questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });
        option4.setOnClickListener(view -> {
            // Ο χρήστης επιλέγει την τέταρτη επιλογή
            userSelectedOption = 4;
            questions.get(currentPosition).setUserSelectedOption(userSelectedOption);
        });

        btn_next.setOnClickListener(view -> {
            if (userSelectedOption == 0) {
                // Εμφάνιση μηνύματος εάν ο χρήστης δεν έχει επιλέξει κάποια επιλογή
                Toast.makeText(QuizLogos.this, "Please select an option", Toast.LENGTH_SHORT).show();
            } else {
                // Εμφάνιση στοιχείων επιλογής και απάντησης
                System.out.println(questions.get(currentPosition).getUserSelectedOption());
                System.out.println(questions.get(currentPosition).getAnswer());
                nextQuestions();
            }
        });
    }
    // Η μέθοδος nextQuestions ενημερώνει τις τιμές των ερωτήσεων ,απαντήσεων καθώς και της τρέχουσας θέσης
    // Αν έχει φτάσει στο τέλος δημιουργείται ένα Intent για την εκκίνηση της Κλάσης Result περνόντας σε αυτήν
    // τις σωστές και λάθος απαντήσεις και το όνομα του χρήστη
    private void nextQuestions() {
        currentPosition++;

        if ((currentPosition + 1) == questions.size()) {
            btn_next.setText("Υποβολή Quiz");
        }
        if (currentPosition < questions.size()) {
            userSelectedOption = 0;

            question_number.setText(currentPosition + 1 + "/10");
            logo.setImageDrawable(photos.get(questions.get(currentPosition).getQuestion()));
            option1.setText(questions.get(currentPosition).getOption1());
            option2.setText(questions.get(currentPosition).getOption2());
            option3.setText(questions.get(currentPosition).getOption3());
            option4.setText(questions.get(currentPosition).getOption4());
        } else {
            Intent intent = new Intent(QuizLogos.this, Result.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            intent.putExtra("name", getIntent().getCharSequenceExtra("name"));
            startActivity(intent);
        }
    }

    private int getCorrectAnswers() {
        int correctAnswers = 0;

        for (int i = 0; i < questions.size(); i++) {
            final int getUserSelectedAnswer = questions.get(i).getUserSelectedOption();
            final int getAnswer = questions.get(i).getAnswer();

            if (getUserSelectedAnswer == getAnswer) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers() {
        int incorrectAnswers = 0;

        for (int i = 0; i < questions.size(); i++) {
            final int getUserSelectedAnswer = questions.get(i).getUserSelectedOption();
            final int getAnswer = questions.get(i).getAnswer();

            if (getUserSelectedAnswer != getAnswer) {
                incorrectAnswers++;
            }
        }
        return incorrectAnswers;
    }

    private void initializePhotos() {
        photos = new HashMap<>();
        photos.put("arsenal", getResources().getDrawable(R.drawable.arsenal));
        photos.put("lester", getResources().getDrawable(R.drawable.lester));
        photos.put("leeds", getResources().getDrawable(R.drawable.leeds));
        photos.put("fuhlam", getResources().getDrawable(R.drawable.fuhlam));
        photos.put("lens", getResources().getDrawable(R.drawable.lens));
        photos.put("lille", getResources().getDrawable(R.drawable.lille));
        photos.put("marseille", getResources().getDrawable(R.drawable.marseille));
        photos.put("psg", getResources().getDrawable(R.drawable.psg));
        photos.put("eintracht", getResources().getDrawable(R.drawable.eintracht));
        photos.put("dortmund", getResources().getDrawable(R.drawable.dortmund));
        photos.put("wolsburg", getResources().getDrawable(R.drawable.wolsburg));
        photos.put("gladbach", getResources().getDrawable(R.drawable.gladbach));
        photos.put("paok", getResources().getDrawable(R.drawable.paok));
        photos.put("pao", getResources().getDrawable(R.drawable.pao));
        photos.put("giannina", getResources().getDrawable(R.drawable.giannina));
        photos.put("volos", getResources().getDrawable(R.drawable.volos));
        photos.put("barca", getResources().getDrawable(R.drawable.barca));
        photos.put("real", getResources().getDrawable(R.drawable.real));
        photos.put("villiareal", getResources().getDrawable(R.drawable.villiareal));
        photos.put("atletico", getResources().getDrawable(R.drawable.atletico));
        photos.put("juventus", getResources().getDrawable(R.drawable.juventus));
        photos.put("napoli", getResources().getDrawable(R.drawable.napoli));
        photos.put("milan", getResources().getDrawable(R.drawable.milan));
        photos.put("inter", getResources().getDrawable(R.drawable.inter));
    }
}
