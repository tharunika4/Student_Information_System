package com.MyExceptions;

public class InvalidCourseDataException extends Exception {
    public InvalidCourseDataException() {
        super("Invalid course data provided for creating or updating a course.");
    }
}
