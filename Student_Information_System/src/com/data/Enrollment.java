package com.data;

import com.MyExceptions.DuplicateEnrollmentException;
import com.MyExceptions.InvalidCourseDataException;
import com.MyExceptions.InvalidEnrollmentDataException;
import com.MyExceptions.PaymentValidationException;

import java.time.LocalDate;
import java.util.*;

public class Enrollment {
    private String courseName;
    private int enrollmentID;
    private int studentID;
    private int courseID;
    private LocalDate enrollmentDate;
    private Student student;
    private Course course;
    private static int id =300;

    public Enrollment(int enrollmentID, int studentID, int courseID, LocalDate enrollmentDate) {
        this.enrollmentID = id++;
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment() {

    }

    public Enrollment(int enrollmentID, Student student, Course course, LocalDate enrollmentDate) {
        this.enrollmentID=id++;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment( Student student, Course course, LocalDate enrollmentDate) {
        this.enrollmentID=id++;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment(int studentID, int courseID, LocalDate enrollmentDate) {
        this.enrollmentID=id++;
        this.studentID=studentID;
        this.courseID=courseID;
        this.enrollmentDate = enrollmentDate;

    }

    public Enrollment(int studentID, int courseID) {
        this.studentID=studentID;
        this.courseID=courseID;
    }

    public Enrollment(int studentID, String courseName) {
        this.studentID=studentID;
        this.courseName=courseName;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }
    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDateDate(LocalDate enrollmentDate) throws InvalidEnrollmentDataException {
        if (enrollmentDate == null || enrollmentDate.isAfter(LocalDate.now())) {
            throw new InvalidEnrollmentDataException();
        }
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "EnrollmentID: " + enrollmentID + " StudentID: " + studentID + " CourseID: " + courseID +
                " EnrollmentDate: " + enrollmentDate;
    }

    public void enrollStudentInCourse(Student student, Course course) throws DuplicateEnrollmentException {
        for (Enrollment enrollment : student.getEnrollments()) {
            if (enrollment.getCourse().equals(course)) {
                throw new DuplicateEnrollmentException();
            }
        }

        List<Course> enrollments = new ArrayList<>();

// Proceed with the enrollment process
        Enrollment enrollment = new Enrollment(enrollments.size()+1,studentID, courseID, enrollmentDate);
        enrollments.add(enrollment.getCourse());
    }
}


