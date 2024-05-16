package com.MyExceptions;

public class InvalidStudentDataException extends Exception {

    public InvalidStudentDataException() {
        super("Invalid student data provided.");
    }
}