package com.data;


import com.MyExceptions.CourseNotFoundException;
import com.MyExceptions.InvalidCourseDataException;

import java.util.*;

public class Course {
    private int courseID;
    private String courseName;
    private String courseCode;
    private String instructorName;
    private String assignedTeacher;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(int courseID, String courseName, String courseCode, String instructorName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.enrollments = new ArrayList<Enrollment>();
    }

    public Course(){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
    }

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructorName() {
        return instructorName;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + " Course Name: " + courseName + " Course Code: " + courseCode +
                " Instructor Name: " + instructorName;
    }

    public void assignTeacher(Teacher teacher) throws InvalidCourseDataException {
        if (teacher == null) {
            throw new InvalidCourseDataException();
        }
        this.assignedTeacher = String.valueOf(teacher);
    }

    public void updateCourseInfo(List<Course> courses, String courseName, String courseCode, String instructorName) throws CourseNotFoundException, InvalidCourseDataException {
        boolean found = false;
        for (Course course : courses) {
            if (courseCode == null || courseCode.isEmpty() || courseName == null || courseName.isEmpty() || instructorName == null || instructorName.isEmpty()) {
                throw new InvalidCourseDataException();
            }
            if (course.getCourseID() == this.courseID) {
                course.setCourseName(courseName);
                course.setCourseCode(courseCode);
                course.setInstructorName(instructorName);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new CourseNotFoundException();
        }
    }


    public void getCourseIfo() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Instructor: " + instructorName);
        }



    public List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public String getTeacher(Course course) {
        return assignedTeacher;
    }

    public String getAssignedTeacher() {
        return assignedTeacher;
    }
    public void setAssignedTeacher(String teacher) {
        this.assignedTeacher = teacher;
    }

}
