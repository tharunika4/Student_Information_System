package com.MyExceptions;

public class DuplicateEnrollmentException extends Exception {

    public DuplicateEnrollmentException() {
        super("Student is already enrolled in this course.");
    }
}