package com.MyExceptions;

public class TeacherNotFoundException extends Exception {
    public TeacherNotFoundException() {
        super("Teacher not found in the system.");
    }
}
