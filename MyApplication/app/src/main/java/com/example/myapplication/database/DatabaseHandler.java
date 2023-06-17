package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * The DatabaseHandler class is responsible for managing SQLite database operations for a quiz application.
 */
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

    /**
     * Constructs a DatabaseHandler object.
     *
     * @param context The application context.
     */
    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // The onCreate method is called when the database is created for the first time.
        // However, since the table already exists, we don't need to implement this method.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The onUpgrade method is called when the database needs to be upgraded to a new version.
        // Since there is no specific implementation needed, we don't implement this method.
    }

    /**
     * Retrieves a list of questions from the database based on the specified category.
     *
     * @param category The category of questions to retrieve.
     * @return A list of Question objects.
     */
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
}
