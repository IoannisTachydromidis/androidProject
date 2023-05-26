package com.example.myapplication.mapper;

import com.example.myapplication.dto.LogoDto;
import com.example.myapplication.dto.QuestionDto;
import com.example.myapplication.model.Logo;
import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

public class LogoDtoMapper {
    private LogoDto logoToDto(Logo temp) {
        return new LogoDto(temp.getQuestion(), temp.getOption1(), temp.getOption2(), temp.getOption3(), temp.getOption4(), temp.getAnswer());
    }

    public List<LogoDto> mapListToDto(List<Logo> temp) {
        List<LogoDto> dtoList = new ArrayList<>();
        for (Logo question : temp) {
            LogoDto dto = logoToDto(question);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
