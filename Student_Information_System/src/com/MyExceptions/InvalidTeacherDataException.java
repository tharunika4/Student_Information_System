package com.MyExceptions;

public class InvalidTeacherDataException extends Exception {
    public InvalidTeacherDataException() {
        super("Invalid teacher data provided.");
    }
}
