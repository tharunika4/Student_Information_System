package com.data;

import java.time.*;

import com.MyExceptions.CourseNotFoundException;
import com.MyExceptions.DuplicateEnrollmentException;
import com.MyExceptions.InvalidCourseDataException;
import com.MyExceptions.TeacherNotFoundException;


public class SIS_Driver {
    public static void main(String[] args) throws TeacherNotFoundException, CourseNotFoundException, DuplicateEnrollmentException, InvalidCourseDataException {
        SIS sis = new SIS();

        Student obj1 = new Student(1001, "Steven", " King", LocalDate.of(2002, 8, 17), "Steveking@gmail.com", "9894850246");
        Student obj2 = new Student(1002, "Anu", " Jain", LocalDate.of(2003, 11, 1), "Anu.jain@gmail.com", "6712345890");
        Student obj3 = new Student(1003, "Julia", " Nayer", LocalDate.of(2003, 5, 25), "JuliaNayer@gmail.com", "9444856832");

        Course course1 = new Course(201, "Science", "24SC101", "Jim Parker");
        Course course2 = new Course(202, "Maths", "24SC102", "Adam Smith");
        Course course3 = new Course(201, "English", "24SC103", "Jim Parker");

        Enrollment enrol1 = new Enrollment(2001, 1001, 201, LocalDate.of(2020,5,18));
        Enrollment enrol2 = new Enrollment(2002, 1001, 203, LocalDate.of(2020,8,24));
        Enrollment enrol3 = new Enrollment(2003, 1002, 202, LocalDate.of(2020,6,3));
        Enrollment enrol4 = new Enrollment(2004, 1003, 203, LocalDate.of(2020,7,7));
        Enrollment enrol5 = new Enrollment(2005, 1003, 202, LocalDate.of(2020,5,25));

        Teacher teacher1 = new Teacher(301, "Jim", " Parker", "Jim.Parker@example.com");
        Teacher teacher2 = new Teacher(302, "Adam", "Smith", "Adam.Smith@example.com");

        // Enroll students in courses
        sis.enrollStudentInCourse(obj1, course1);
        sis.enrollStudentInCourse(obj2, course2);
        sis.enrollStudentInCourse(obj2, course1);

        // Assign teachers to courses
        sis.assignTeacherToCourse(teacher1, course1);
        sis.assignTeacherToCourse(teacher2, course2);

        // Record payments
        sis.recordPayment(obj1, 500.0, LocalDate.of(2023, 4, 1));
        sis.recordPayment(obj2, 300.0, LocalDate.of(2023, 5, 15));
        sis.recordPayment(obj3, 400.0, LocalDate.of(2023, 3, 20));

        // Display course information
        course1.getCourseIfo();
        System.out.println();
        course2.getCourseIfo();

        // Generate reports
        sis.generateEnrollmentReport(course1);
        sis.generatePaymentReport(obj1);
        sis.calculateCourseStatistics(course1);

        // Display student information
        obj1.displayStudentInfo();
        System.out.println();
        obj2.displayStudentInfo();

        // Display teacher information
        teacher1.displayTeacherInfo();
        System.out.println();
        teacher2.displayTeacherInfo();

    }
}
