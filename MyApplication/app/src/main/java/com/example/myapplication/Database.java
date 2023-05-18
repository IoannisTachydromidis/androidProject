package com.example.myapplication;

import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Question> historyOptions(){
        final List<Question> questionList = new ArrayList<>();

        Question question1 = new Question("H1o1","H1o2","H1o3","H1o4","H1o2","");
        Question question2 = new Question("H2o1","H2o2","H2o3","H2o4","H2o4","");
        Question question3 = new Question("H3o1","H3o2","H3o3","H3o4","H3o1","");
        Question question4 = new Question("H4o1","H4o2","H4o3","H4o4","H4o2","");
        Question question5 = new Question("H5o1","H5o2","H5o3","H5o4","H5o4","");
        Question question6 = new Question("H6o1","H6o2","H6o3","H6o4","H6o2","");
        Question question7 = new Question("H7o1","H7o2","H7o3","H7o4","H7o1","");
        Question question8 = new Question("H8o1","H8o2","H8o3","H8o4","H8o2","");
        Question question9 = new Question("H9o1","H9o2","H9o3","H9o4","H9o2","");
        Question question10 = new Question("H10o1","H10o2","H10o3","H10o4","H10o3","");

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }
    public static List<String> historyQuestions(){
        List<String> questionsList  = new ArrayList<>();

        questionsList.add("QH1");
        questionsList.add("QH2");
        questionsList.add("QH3");
        questionsList.add("QH4");
        questionsList.add("QH5");
        questionsList.add("QH6");
        questionsList.add("QH7");
        questionsList.add("QH8");
        questionsList.add("QH9");
        questionsList.add("QH10");

        return questionsList;
    }

    public static List<Question> geographyQuestions(){
        final List<Question> questionList = new ArrayList<>();

        return questionList;
    }

    public static List<Question> randomQuestions(){
        final List<Question> questionList = new ArrayList<>();

        return questionList;
    }

    public static List<Question> getOptionsFromDB(String category){
        switch (category){
            case "history":
                return historyOptions();
            case "geography":
                return geographyQuestions();
            case "random":
                return randomQuestions();
        }
        return historyOptions();
    }

    public static List<String> getQuestionsFromDB(String category){
        switch (category){
            case "history":
                return historyQuestions();
            //case "geography":
               // return geographyQuestions();
           // case "random":
              //  return randomQuestions();
        }
        return historyQuestions();
    }
}
