package com.data;

import java.time.*;
import java.util.*;

import com.data.Enrollment;
import com.MyExceptions.CourseNotFoundException;
import com.MyExceptions.PaymentValidationException;
import com.MyExceptions.DuplicateEnrollmentException;

public class Student {

    private int courseID;
    private LocalDate enrollmentDate;
    private int studentID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private double balance;
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<Payment> paymentHistory = new ArrayList<>();

    public Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(){

    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + " First Name: " + firstName + " Last Name: " + lastName + " Date of Birth: "
                + dateOfBirth + " Email: " + email + " Phone Number: " + phoneNumber;
    }

 //  Enroll student in course
    public void enrollInCourse(Course course) throws DuplicateEnrollmentException {
        // Check if the student is already enrolled in the course
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                throw new DuplicateEnrollmentException();
            }
        }

        // Proceed with the enrollment process
        Enrollment enrollment = new Enrollment(enrollments.size() + 1, this, course, LocalDate.now());
        enrollments.add(enrollment);
        course.getEnrollments().add(enrollment);
    }

 //   Update student info
    public void updateStudentInfo(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

  // Make payments
    public void makePayment(double amount, LocalDateTime paymentDate) throws PaymentValidationException {
        if (amount <= 0) {
            throw new PaymentValidationException();
        }
        Payment payment = new Payment(paymentHistory.size()+1, this, amount, paymentDate.toLocalDate());
        paymentHistory.add(payment);
    }
  // Display student information
    public void displayStudentInfo() {
        System.out.println(toString());
    }


    public List<Course> getEnrolledCourses() {
        List<Course> courses = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            courses.add(enrollment.getCourse());
        }
        return courses;
    }

    public List<Payment> getPaymentHistory() {
        return new ArrayList<>(paymentHistory);
    }

    public List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
