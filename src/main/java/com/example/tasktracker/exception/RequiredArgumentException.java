package com.example.tasktracker.exception;

public class RequiredArgumentException extends Exception {
    public RequiredArgumentException(String message) {
        super(message);
    }
}
