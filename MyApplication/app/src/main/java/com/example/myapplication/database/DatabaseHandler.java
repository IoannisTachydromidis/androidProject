package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.myapplication.mapper.model.Logo;
import com.example.myapplication.mapper.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table name
    private static final String TABLE_NAME = "quiz";

    // Table columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_OPTION1 = "option1";
    private static final String COLUMN_OPTION2 = "option2";
    private static final String COLUMN_OPTION3 = "option3";
    private static final String COLUMN_OPTION4 = "option4";
    private static final String COLUMN_ANSWER = "answer";
    private static final String COLUMN_CATEGORY = "category";

    private final Context context;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No need to implement this method since the table already exists
    }

    public List<Question> getQuestionsByCategory(int category) {
        List<Question> questionsList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_CATEGORY + " = " + category;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            int idIndex = cursor.getColumnIndex(COLUMN_ID);
            int questionIndex = cursor.getColumnIndex(COLUMN_QUESTION);
            int option1Index = cursor.getColumnIndex(COLUMN_OPTION1);
            int option2Index = cursor.getColumnIndex(COLUMN_OPTION2);
            int option3Index = cursor.getColumnIndex(COLUMN_OPTION3);
            int option4Index = cursor.getColumnIndex(COLUMN_OPTION4);
            int answerIndex = cursor.getColumnIndex(COLUMN_ANSWER);
            int categoryIndex = cursor.getColumnIndex(COLUMN_CATEGORY);

            while (cursor.moveToNext()) {
                long id = cursor.getLong(idIndex);
                String question = cursor.getString(questionIndex);
                String option1 = cursor.getString(option1Index);
                String option2 = cursor.getString(option2Index);
                String option3 = cursor.getString(option3Index);
                String option4 = cursor.getString(option4Index);
                int answer = cursor.getInt(answerIndex);
                int categoryValue = cursor.getInt(categoryIndex);

                Question questions = new Question(id, question, option1, option2, option3, option4, answer, categoryValue);
                questionsList.add(questions);
            }

            cursor.close();
        }

        return questionsList;
    }

    public List<Logo> getLogosByCategory(int category) {
        List<Logo> logoList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_CATEGORY + " = " + category;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            int idIndex = cursor.getColumnIndex(COLUMN_ID);
            int questionIndex = cursor.getColumnIndex(COLUMN_QUESTION);
            int option1Index = cursor.getColumnIndex(COLUMN_OPTION1);
            int option2Index = cursor.getColumnIndex(COLUMN_OPTION2);
            int option3Index = cursor.getColumnIndex(COLUMN_OPTION3);
            int option4Index = cursor.getColumnIndex(COLUMN_OPTION4);
            int answerIndex = cursor.getColumnIndex(COLUMN_ANSWER);
            int categoryIndex = cursor.getColumnIndex(COLUMN_CATEGORY);

            while (cursor.moveToNext()) {
                long id = cursor.getLong(idIndex);
                String questionPath = cursor.getString(questionIndex);
                String option1 = cursor.getString(option1Index);
                String option2 = cursor.getString(option2Index);
                String option3 = cursor.getString(option3Index);
                String option4 = cursor.getString(option4Index);
                int answer = cursor.getInt(answerIndex);
                int categoryValue = cursor.getInt(categoryIndex);

                // Load the image from the questionPath and set it to the ImageView
                ImageView questionImageView = new ImageView(context);
                questionImageView.setImageBitmap(BitmapFactory.decodeFile(questionPath));

                // Create a new instance of the Logo class
                Logo logo = new Logo(id, questionImageView, option1, option2, option3, option4, answer, categoryValue);

                logoList.add(logo);
            }

            cursor.close();
        }

        return logoList;
    }



}
