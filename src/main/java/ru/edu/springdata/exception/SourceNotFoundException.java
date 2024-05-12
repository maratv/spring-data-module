package ru.edu.springdata.exception;

public class SourceNotFoundException extends RuntimeException{
    public SourceNotFoundException(String message) {
        super(message);
    }
}
