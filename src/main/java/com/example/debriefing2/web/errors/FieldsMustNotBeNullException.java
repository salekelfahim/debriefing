package com.example.debriefing2.web.errors;

public class FieldsMustNotBeNullException extends RuntimeException {
    public FieldsMustNotBeNullException(String message) {
        super(message);
    }
}
