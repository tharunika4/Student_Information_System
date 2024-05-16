package com.Tasks;

import com.DAO.CourseDAO;
import com.DAO.EnrollmentDAO;
import com.DAO.PaymentDAO;
import com.DAO.StudentDAO;
import com.data.Enrollment;

import java.sql.SQLException;
import java.util.List;

public class Task11EnrollmentReportGeneration {
    public static void main(String[] args) throws SQLException {
        // Create instances of DAO classes
        StudentDAO studentDAO = new StudentDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        CourseDAO courseDAO = new CourseDAO();


        enrollmentDAO.getEnrollmentsByCourse("Computer Science 101");

    }

    }


