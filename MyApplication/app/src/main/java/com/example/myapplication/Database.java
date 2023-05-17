package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Questions> historyOptions(){
        final List<Questions> questionsList = new ArrayList<>();

        Questions question1 = new Questions("H1o1","H1o2","H1o3","H1o4","H1o2","");
        Questions question2 = new Questions("H2o1","H2o2","H2o3","H2o4","H2o4","");
        Questions question3 = new Questions("H3o1","H3o2","H3o3","H3o4","H3o1","");
        Questions question4 = new Questions("H4o1","H4o2","H4o3","H4o4","H4o2","");
        Questions question5 = new Questions("H5o1","H5o2","H5o3","H5o4","H5o4","");
        Questions question6 = new Questions("H6o1","H6o2","H6o3","H6o4","H6o2","");
        Questions question7 = new Questions("H7o1","H7o2","H7o3","H7o4","H7o1","");
        Questions question8 = new Questions("H8o1","H8o2","H8o3","H8o4","H8o2","");
        Questions question9 = new Questions("H9o1","H9o2","H9o3","H9o4","H9o2","");
        Questions question10 = new Questions("H10o1","H10o2","H10o3","H10o4","H10o3","");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
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

    public static List<Questions> geographyQuestions(){
        final List<Questions> questionsList = new ArrayList<>();

        return questionsList;
    }

    public static List<Questions> randomQuestions(){
        final List<Questions> questionsList = new ArrayList<>();

        return questionsList;
    }

    public static List<Questions> getOptionsFromDB(String category){
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
