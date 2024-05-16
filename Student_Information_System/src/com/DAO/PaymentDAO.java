package com.DAO;

import com.JdbcConnection.ConnectionFactory;
import com.data.Payment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PaymentDAO implements Dao {

    @Override
    public void insert(Object obj) throws SQLException {
        if (!(obj instanceof Payment)) {
            throw new IllegalArgumentException("Object is not of type Payment");
        }

        Payment payment = (Payment) obj;
        String sql = "INSERT INTO Payment (paymentID, studentID, amount, paymentDate) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, payment.getPaymentID());
            preparedStatement.setInt(2, payment.getStudentID());
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.setDate(4, Date.valueOf(payment.getPaymentDate()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id,Object obj) throws SQLException {
        if (!(obj instanceof Payment)) {
            throw new IllegalArgumentException("Object is not of type Payment");
        }

        Payment payment = (Payment) obj;
        String sql = "UPDATE Payment SET studentID=?, amount=?, paymentDate=? WHERE paymentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, payment.getStudentID());
            preparedStatement.setDouble(2, payment.getAmount());
            preparedStatement.setDate(3, Date.valueOf(payment.getPaymentDate()));
            preparedStatement.setInt(4, payment.getPaymentID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Payment WHERE paymentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Payment> DisplayAll() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int paymentID = resultSet.getInt("paymentID");
                int studentID = resultSet.getInt("studentID");
                double amount = resultSet.getDouble("amount");
                LocalDate paymentDate = resultSet.getDate("paymentDate").toLocalDate();
                payments.add(new Payment(paymentID, studentID, amount, paymentDate));
            }
        }
        return payments;
    }


}

