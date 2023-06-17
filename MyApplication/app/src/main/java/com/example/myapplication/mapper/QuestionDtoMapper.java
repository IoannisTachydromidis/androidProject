package com.example.myapplication.mapper;

import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.mapper.model.Question;

import java.util.ArrayList;
import java.util.List;

//Its purpose is to map a Question to a QuestionDto
public class QuestionDtoMapper {

    private QuestionDto questionToDto(Question temp) {
        return new QuestionDto(temp.getQuestion(), temp.getOption1(), temp.getOption2(), temp.getOption3(), temp.getOption4(), temp.getAnswer());
    }

    public List<QuestionDto> mapListToDto(List<Question> temp) {
        List<QuestionDto> dtoList = new ArrayList<>();
        for (Question question : temp) {
            QuestionDto dto = questionToDto(question);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
