package com.example.debriefing2.web.errors;

public class FarmFieldsNotAllowedException extends RuntimeException {
    public FarmFieldsNotAllowedException(String message) {
        super(message);
    }
}
