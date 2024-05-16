package com.MyExceptions;

public class InvalidEnrollmentDataException extends Exception {
    public InvalidEnrollmentDataException() {
        super("Invalid enrollment data provided.");
    }
}

