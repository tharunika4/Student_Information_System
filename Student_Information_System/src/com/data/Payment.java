package com.data;

import com.MyExceptions.PaymentValidationException;

import java.time.LocalDate;
import java.util.Date;

public class Payment {
    private int studentID;
    private int paymentID;
    private Student student;
    private double amount;
    private LocalDate paymentDate;
    private static int ID_increment= 1;

    public Payment( Student student, double amount, LocalDate paymentDate) {
        this.paymentID = ID_increment++;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment( int studentID, double amount, LocalDate paymentDate) {
        this.paymentID = ID_increment++;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(){

    }

    public Payment(int paymentID,Student student, double amount, LocalDate paymentDate) {
        this.paymentID = paymentID;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(int paymentID, int studentID, double amount, LocalDate paymentDate) {
        this.paymentID = paymentID;
        this.studentID = studentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(int studentID, double amount) {
        this.studentID=studentID;
        this.amount=amount;
    }


    public int getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student)throws PaymentValidationException {
        if (student == null) {
            throw new PaymentValidationException();
        }
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) throws PaymentValidationException {
        if (paymentDate == null || paymentDate.isAfter(LocalDate.now())) {
            throw new PaymentValidationException();
        }
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentID: " + paymentID + " Student: " + student + " Amount: " + amount + " PaymentDate: " + paymentDate;
    }


    public double getPaymentAmount() {
        return amount;
    }

    public int getStudentID() {
        return studentID;
    }

}