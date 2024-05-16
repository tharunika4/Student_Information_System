package com.data;

import java.time.*;
import java.util.*;

import com.MyExceptions.*;


import java.util.List;

public class SIS {
    private List<Student> studentsList;
    private List<Course> coursesList;
    private List<Enrollment> enrollments;
    private List<Teacher> teachersList;
    private List<Payment> payments;

    public SIS() {
        this.studentsList = new ArrayList<>();
        this.coursesList = new ArrayList<>();
        this.enrollments = new ArrayList<>();
        this.teachersList = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    Enrollment enrollment;
    public void enrollStudentInCourse(Student student, Course course) throws CourseNotFoundException, DuplicateEnrollmentException {
        Enrollment newEnrolment = new Enrollment(enrollments.size() + 1, student, course, LocalDate.now());
        enrollments.add(newEnrolment);
        student.enrollInCourse(course); // Pass the course parameter
        course.getEnrollments().add(newEnrolment);
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) throws TeacherNotFoundException, InvalidCourseDataException {
        course.setInstructorName(teacher.getName());
    }

    public void recordPayment(Student student, double amount, LocalDate paymentDate) {
        Payment payment = new Payment(student, amount, paymentDate);
        payments.add(payment);
        student.getPaymentHistory().add(payment);
    }

    public void generateEnrollmentReport(Course course) {
        List<Enrollment> courseEnrolments = course.getEnrollments();
        System.out.println("Enrolment Report for Course: " + course.getCourseName());
        for (Enrollment enrolment : courseEnrolments) {
            Student student = enrolment.getStudent();
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void generatePaymentReport(Student student) {
        List<Payment> paymentHistory = student.getPaymentHistory();
        System.out.println("Payment Report for Student: " + student.getFirstName() + " " + student.getLastName());
        for (Payment payment : paymentHistory) {
            System.out.println("Payment ID: " + payment.getPaymentID() +" Amount: " + payment.getAmount()+
                    " Payment Date: " + payment.getPaymentDate());
        }
    }

    public void calculateCourseStatistics(Course course) {
        int enrollmentCount = 0;
        double totalPayments = 0.0;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                enrollmentCount++;
                for (Payment payment : payments) {
                    if (payment.getStudent().equals(enrollment.getStudent())) {
                        totalPayments += payment.getAmount();
                    }
                }
            }
        }
        System.out.println("Course Statistics for " + course.getCourseName());
        System.out.println("Number of Enrollments: " + enrollmentCount);
        System.out.println("Total Payments: " + totalPayments);
    }

    public Enrollment addEnrolment(Student student, Course course, LocalDate enrollmentDate) {
        Enrollment enrollment = new Enrollment(enrollments.size() + 1, student, course, enrollmentDate);
        enrollments.add(enrollment);
        student.getEnrollments().add(enrollment);
        course.getEnrollments().add(enrollment);
        return enrollment;
    }

    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.setAssignedTeacher(teacher.getName());
        teacher.getAssignedCourses().add(course);
    }

    public void addPayment(Student student, int amount, LocalDate paymentDate) {
        Payment payment = new Payment(student, amount, paymentDate);
        payments.add(payment);
        student.getPaymentHistory().add(payment);
    }

    public List<Enrollment> getEnrolmentsForStudent(Student student) {
        List<Enrollment> studentEnrolments = new ArrayList<>();
        for (Enrollment enrolment : enrollments) {
            if (enrolment.getStudent().equals(student)) {
                studentEnrolments.add(enrolment);
            }
        }
        return studentEnrolments;
    }

    public List<Course> getCoursesForTeacher(Teacher teacher) {
        List<Course> teacherCourses = new ArrayList<>();
        for (Course course : coursesList) {
            if (course.getAssignedTeacher().equals(teacher)) { // Use getAssignedTeacher() method
                teacherCourses.add(course);
            }
        }
        return teacherCourses;
    }
}
