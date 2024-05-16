package com.data;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherID;
    private String name;
    private String expertise;
    private String email;
    private List<Course> assignedCourses = new ArrayList<>();

    public Teacher(int teacherID, String name, String expertise, String email) {
        this.teacherID = teacherID;
        this.name = name;
        this.expertise = expertise;
        this.email = email;
    }

    public Teacher() {

    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher ID: " + teacherID + " Name: " + name + " Expertise: " + expertise + " Email: " + email;
    }


    public void updateTeacherInfo(String name, String expertise, String email) {
        this.name = name;
        this.expertise = expertise;
        this.email = email;
    }

    public void displayTeacherInfo() {
        System.out.println(toString());
    }

    // Method to add a course to the list of assigned courses
    public void addAssignedCourse(Course course) {
        assignedCourses.add(course);
    }

    // Method to get the list of assigned courses
    public List<Course> getAssignedCourses() {
        return new ArrayList<>(assignedCourses);

    }
}

