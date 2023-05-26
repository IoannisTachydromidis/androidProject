package com.example.myapplication.exceptions;

import java.util.List;

public class WrongCategoryException extends RuntimeException{

    private int except;

    public WrongCategoryException (int except) {
        this.except = except;
    }

    public int getException() {
        return except;
    }

    @Override
    public String getMessage() {
        if (except==1)
            return "Wrong category";
        else if (except==2)
            return "Invalid category";
        else
            return "Problem";
    }
}

