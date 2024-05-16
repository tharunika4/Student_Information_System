package com.DAO;

import com.data.*;

import java.sql.SQLException;
import java.util.*;
import java.time.*;

public class Main {

    public static void main(String[] args) throws SQLException {


        StudentDAO studentDAO = new StudentDAO();

        // Sample student and course
        Student obj1 = new Student(1001, "John", "Doe", LocalDate.of(1995, 8, 15), "john.doe@example.com", "123456789");
        Course course1 = new Course(201, "Science", "SC101", "Dr. Smith");

        Student obj2 = new Student(1002, "Anu", " Jain", LocalDate.of(1998, 11, 1), "Anu.jain@gmail.com", "6712345890");
        Student obj3 = new Student(1003, "Julia", " Nayer", LocalDate.of(1997, 5, 25), "JuliaNayer@gmail.com", "9444856832");

//
//        try {
//            // Insert the student data into the database
//
//           studentDAO.insert(obj1);
//          studentDAO.insert(obj2);
//          studentDAO.insert(obj3);
//          System.out.println("Student data inserted successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error inserting student data: " + e.getMessage());
//       }

  /*      // Update Student Data
            try {
                Scanner scannerObj = new Scanner(System.in);
                int id,studentID;
                String lastName, firstName, email, phoneNumber;
                LocalDate dateOfBirth;
                // Update the student data in the database
                System.out.println("Enter details");
                firstName = scannerObj.next();
                lastName = scannerObj.next();
                dateOfBirth = LocalDate.parse(scannerObj.next());
                email = scannerObj.next();
                phoneNumber = scannerObj.next();
                studentID = scannerObj.nextInt();
                studentDAO.update(1002, new Student(firstName, lastName, dateOfBirth, email, phoneNumber));
                System.out.println("Student data updated successfully.");
            } catch (SQLException e) {
                System.err.println("Error updating student data: " + e.getMessage());
            }
*/


//        try {
//            // Insert the course data into the database
//            CourseDAO courseDAO = new CourseDAO();
//            courseDAO.insert(course1);
//            System.out.println("Course data inserted successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error inserting Course data: " + e.getMessage());
//        }

//
//        // Sample payment details
//        double amount = 500.00;
//        LocalDate paymentDate = LocalDate.now();
//
//        // Create TransactionManager instance
            TransactionManager transactionManager = new TransactionManager();
//
//        // Enroll student in course and record payment
//        try {
//            Student student = new Student();
//            transactionManager.enrollStudentWithPayment(student, course, amount, paymentDate);
//            System.out.println("Student enrolled and payment recorded successfully!");
//        } catch (Exception e) {
//            System.out.println("Failed to enroll student and record payment: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//
//        // Displaying all data

            StudentDAO studentDao = new StudentDAO();
            List<Student> students = studentDao.DisplayAll();
            System.out.println("Students:");
            for (Object s : students) {
                System.out.println(s);
            }

//        CourseDAO courseDao = new CourseDAO();
//        List<Course> courses = courseDao.DisplayAll();
//        System.out.println("\nCourses:");
//        for (Object c : courses) {
//            System.out.println(c);
//        }

//        TeacherDAO teacherDao = new TeacherDAO();
//        List<Teacher> teachers = teacherDao.DisplayAll();
//        System.out.println("\nTeachers:");
//        for (Object t : teachers) {
//            System.out.println(t);
//        }

//        EnrollmentDAO enrollmentDao = new EnrollmentDAO();
//        List<Enrollment> enrollments = enrollmentDao.DisplayAll();
//        System.out.println("\nEnrollments:");
//        for (Object e : enrollments) {
//            System.out.println(e);
//        }

//        PaymentDAO paymentDao = new PaymentDAO();
//        List<Payment> payments = paymentDao.DisplayAll();
//        System.out.println("\nPayments:");
//        for (Object p : payments) {
//            System.out.println(p);
//        }

/*        // delete student
        studentDAO.delete(1001);
        studentDAO.delete(1002);
        studentDAO.delete(1003);
*/
        }
    }


