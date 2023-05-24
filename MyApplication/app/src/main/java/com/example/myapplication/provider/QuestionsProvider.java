package com.example.myapplication.provider;

import android.content.Context;

import com.example.myapplication.database.DatabaseHandler;
import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.mapper.QuestionDtoMapper;
import com.example.myapplication.model.Question;

import java.util.Collections;
import java.util.List;

//Its purpose is to be provide questions in the QuestionDto format to the application
public class QuestionsProvider {

    private DatabaseHandler  handler;

    public QuestionsProvider(Context context) {
        // Initialize the DatabaseHandler instance with the provided Context
        handler = new DatabaseHandler(context);
    }


    //Method to get 10 questions, from the DatabaseHandler, of the given category and map them to a QuestionDto list
    public List<QuestionDto> getQuestions(int category) {
        List<Question> questions = handler.getQuestionsByCategory(category);

        //pick 10 random from the questions list

        // Shuffle the questions list to randomize the order
        Collections.shuffle(questions);

        // Select the first 10 questions (or fewer if there are fewer than 10 questions available)
        int numQuestionsToRetrieve = Math.min(10, questions.size());
        List<Question> selectedQuestions = questions.subList(0, numQuestionsToRetrieve);

        QuestionDtoMapper mapper = new QuestionDtoMapper();
        return mapper.mapListToDto(selectedQuestions);
    }
}
