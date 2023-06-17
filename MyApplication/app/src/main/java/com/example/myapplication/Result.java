package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Result extends AppCompatActivity {

    // private List previousScores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        // Ανάθεση αντικειμένων της διεπαφής χρήστη (UI) στις μεταβλητές
        AppCompatButton start_new_quiz = findViewById(R.id.startNewQuiz);
        TextView correctAnswers = findViewById(R.id.correctAnswers);
        TextView wrongAnswers = findViewById(R.id.wrongAnswers);
        TextView congratsText = findViewById(R.id.congratsText);

        // Λήψη του ονόματος του χρήστη από το Intent
        CharSequence name = getIntent().getCharSequenceExtra("name");
        congratsText.setText("Συγχαρητήρια " + name);

        // Λήψη του αριθμού των σωστών και λανθασμένων απαντήσεων από το Intent
        int numberOfCorrectAnswers = getIntent().getIntExtra("correct", 0);
        int numberOfWrongAnswers = getIntent().getIntExtra("incorrect", 0);

        // Εμφάνιση των αποτελεσμάτων στα κατάλληλα TextView
        correctAnswers.setText("Οι σωστές απαντήσεις είναι " + numberOfCorrectAnswers);
        wrongAnswers.setText("Οι λανθασμένες απαντήσεις είναι " + numberOfWrongAnswers);

        // Ορισμός ακροατή για το κουμπί "Νέο κουίζ"
        start_new_quiz.setOnClickListener(view -> {
            // Δημιουργία Intent για την εκκίνηση της MainActivity
            Intent intent = new Intent(Result.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
