package com.example.myapplication.dto;

// Method that defines the Question model DTO
// Its purpose is to be used for the application
public class QuestionDto {
    private String question;
    private String option1, option2, option3, option4;
    private int answer;

    private int userSelectedOption;

    // Constructor to initialize the QuestionDto object
    public QuestionDto(String question, String option1, String option2, String option3, String option4, int answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.userSelectedOption = 0;
    }

    // Getter methods for retrieving the question and options
    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    // Getter method for retrieving the answer
    public int getAnswer() {
        return answer;
    }

    // Getter and setter methods for the user-selected option
    public int getUserSelectedOption() {
        return userSelectedOption;
    }

    public void setUserSelectedOption(int userSelectedOption) {
        this.userSelectedOption = userSelectedOption;
    }
}
