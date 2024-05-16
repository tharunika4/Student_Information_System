package com.DAO;

import com.JdbcConnection.ConnectionFactory;
import com.data.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TransactionManager {

    public static void enrollStudentWithTeacher(Student student, Course course, Teacher teacher, LocalDate enrollmentDate) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Enroll student
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
            Enrollment enrollment = new Enrollment(student.getStudentID(), course.getCourseID(), enrollmentDate);
            enrollmentDAO.insert(enrollment);

            // Assign teacher
            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.insert(teacher);

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            // Rollback transaction in case of error
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Ensure connection is closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }


    public void enrollStudentWithPayment(Student student, Course course, double amount, LocalDate paymentDate) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Enroll student
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
            Enrollment enrollment = new Enrollment(student.getStudentID(), course.getCourseID());
            enrollmentDAO.insertEnrollment(enrollment);

            // Record payment
            PaymentDAO paymentDAO = new PaymentDAO();
            Payment payment = new Payment(student.getStudentID(), amount, paymentDate);
            paymentDAO.insert(payment);

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            // Rollback transaction in case of error
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Ensure connection is closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }

    // Assign instructor to course
    public static void assignInstructorToCourse(Course course, Teacher teacher) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Assign instructor to the course
            CourseDAO courseDAO = new CourseDAO();
            courseDAO.assignInstructorToCourse(course.getCourseID(), teacher.getName(),teacher.getEmail());

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            // Rollback transaction in case of error
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Ensure connection is closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }

}