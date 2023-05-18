package com.example.myapplication.provider;

import android.content.Context;

import com.example.myapplication.DatabaseHandler;
import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.mapper.QuestionDtoMapper;
import com.example.myapplication.model.Question;

import java.util.List;

//Its purpose is to be provide questions in the QuestionDto format to the application
public class QuestionsProvider {

    private DatabaseHandler  handler;

    public QuestionsProvider(Context context) {
        // Initialize the DatabaseHandler instance with the provided Context
        handler = new DatabaseHandler(context);
    }


    //Method to get 10 questions, from the DatabaseHandler, of the given category and map them to a QuestionDto list
    private List<QuestionDto> getQuestions (int category) {
        List<Question> questions = handler.getQuestionsByCategory(category);
        QuestionDtoMapper mapper = new QuestionDtoMapper();
        return mapper.mapListToDto(questions);
    }
}
