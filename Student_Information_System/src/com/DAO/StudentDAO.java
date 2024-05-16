package com.DAO;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

import com.JdbcConnection.ConnectionFactory;
import com.data.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO implements Dao {


    private Connection myConnectionObject;

    public StudentDAO(Connection myConnectionObject) {
        super();
        this.myConnectionObject = myConnectionObject;
    }

    public StudentDAO() {

    }

    public StudentDAO(String pallavi, String s, LocalDate of, String mail, String number) {
        this.myConnectionObject = myConnectionObject;
    }

    @Override
    public void insert(Object obj) throws SQLException {

        Student student = (Student) obj;
        String sql = "INSERT INTO Student (studentID, firstName, lastName, dateOfBirth, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, student.getStudentID());
             preparedStatement.setString(2, student.getFirstName());
             preparedStatement.setString(3, student.getLastName());
             preparedStatement.setDate(4, Date.valueOf(student.getDateOfBirth()));
             preparedStatement.setString(5, student.getEmail());
             preparedStatement.setString(6, student.getPhoneNumber());
             preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id,Object obj) throws SQLException {
        if (!(obj instanceof Student)) {
            throw new IllegalArgumentException("Object is not of type Teacher");
        }
        Student student = (Student) obj;
        String sql ="UPDATE Student SET firstName=?,lastName=?,dateOfBirth=?,email=?,phoneNumber=? Where studentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
               preparedStatement.setString(1, student.getFirstName());
               preparedStatement.setString(2, student.getLastName());
               preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
               preparedStatement.setString(4, student.getEmail());
               preparedStatement.setString(5, student.getPhoneNumber());
               preparedStatement.setInt(6, student.getStudentID());
               preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Student WHERE studentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Student> DisplayAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                java.sql.Date dob = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = dob.toLocalDate();
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                students.add(new Student(studentID, firstName, lastName, dateOfBirth, email, phoneNumber));
            }
        }
        return  students;
    }

    // get studet data by id
    public Student getStudentById(int studentID) {
        Student student = null;
        String sql = "SELECT * FROM Student WHERE studentID = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("studentID");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    student = new Student(id, firstName, lastName, dateOfBirth, email, phoneNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


}

