package com.quiz.exception;

public class WordCountFileNotFoundException extends RuntimeException {
    public WordCountFileNotFoundException(String message) {
        super(message);
    }
}
