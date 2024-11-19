package com.example.debriefing2.web.errors;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FarmFieldsNotAllowedException.class)
    public String FarmFieldsNotAllowed(FarmFieldsNotAllowedException ex){
        return ex.getMessage();
    }


}