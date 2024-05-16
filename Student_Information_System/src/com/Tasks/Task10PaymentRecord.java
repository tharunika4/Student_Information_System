package com.Tasks;

import com.DAO.CourseDAO;
import com.DAO.PaymentDAO;
import com.DAO.StudentDAO;
import com.DAO.TransactionManager;
import com.data.Payment;
import com.data.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class Task10PaymentRecord {
    public static void main(String[] args) throws SQLException {

        // Create instances of DAO classes
        StudentDAO studentDAO = new StudentDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        TransactionManager transactionManager = new TransactionManager();
        CourseDAO courseDAO = new CourseDAO();

//        studentDAO.delete(101);

        Student student1 = new Student(101, "Jane", " Johnson", LocalDate.of(1998, 11, 01), "Jane.Johnson@example.com", "654321789");
        // Insert the stdnt data into the database
        try {
            studentDAO.insert(student1);
            System.out.println("Student inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting stdnt data: " + e.getMessage());
            ;
        }

        // Retrieve Jane Johnson's stdnt record
        Student stdnt = studentDAO.getStudentById(student1.getStudentID());

        if (stdnt != null) {
            System.out.println("Student record found:");
            System.out.println(stdnt);
        } else {
            System.out.println("Student record not found for ID: " + student1.getStudentID());
        }

        // Jane Johnson's details
        int studentID = 101;
        double paymentAmount = 500.00;
        LocalDate paymentDate = LocalDate.of(2023, 4, 10);
        // Create a new Payment object
        Payment payment = new Payment(studentID, paymentAmount, paymentDate);
        try {
            // Record the payment in the database
            paymentDAO.insert(payment);
            System.out.println("Payment recorded successfully for stdnt ID: " + studentID);
        } catch (SQLException e) {
            System.out.println("Failed to record payment: " + e.getMessage());
            e.printStackTrace();
        }

        // Update Jane's outstanding balance
        Student student = studentDAO.getStudentById(student1.getStudentID());
        try{if (student != null) {
            double currentBalance = student.getBalance();
            double updatedBalance = currentBalance - paymentAmount;
            student.setBalance(updatedBalance);
            studentDAO.update(studentID, student);
            System.out.println("Jane Johnson's outstanding balance updated successfully.");
        } else {
            System.out.println("Failed to retrieve stdnt information for stdnt ID: " + studentID);
        } }catch(SQLException e){
            System.out.println("Failed to record payment or update balance: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }

