package com.Tasks;

import com.DAO.EnrollmentDAO;
import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.DAO.TransactionManager;
import com.data.*;
import java.sql.SQLException;
import java.time.*;


public class Task8StudentEnrollment {

    public static void main(String[] args) throws SQLException{
        // Create instances of DAO classes
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

//        teacherDAO.delete(401);
//        studentDAO.delete(1001);
//        enrollmentDAO.delete(300);
//        enrollmentDAO.delete(301);

        // Create a new student1
        Student student1 = new Student(1001, "John", "Doe", LocalDate.of(1995, 8, 15), "john.doe@example.com", "123456789");
        try {
            // Insert the student data into the database
           studentDAO.insert(student1);
          System.out.println("Student data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting student data: " + e.getMessage());
       }

        // Create a new teacher
        Teacher teacher1 = new Teacher(401, "Dr. Smith", "Mathematics", "smith@example.com");
        try {
            // Insert the teacher data into the database
            teacherDAO.insert(teacher1);
            System.out.println("Teacher data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting student data: " + e.getMessage());
        }


        // Create courses
        Course course1 = new Course(201, "Introduction to Programming", "PROG101", "Johnson");
        Course course2 = new Course(202, "Mathematics 101", "MATH101", "Smith");


        try{LocalDate enrollmentDate = LocalDate.now();
        TransactionManager.enrollStudentWithTeacher(student1, course1, teacher1,enrollmentDate);
        TransactionManager.enrollStudentWithTeacher(student1, course2, teacher1,enrollmentDate);


        System.out.println("Student enrolled and records created successfully.");} catch (Exception e) {
            System.err.println("Error inserting student data: " + e.getMessage());
        }

    }
}