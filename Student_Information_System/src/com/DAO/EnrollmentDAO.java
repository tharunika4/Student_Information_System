package com.DAO;

import com.JdbcConnection.ConnectionFactory;
import com.data.Enrollment;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EnrollmentDAO implements Dao {

    @Override
    public void insert(Object obj) throws SQLException {
        if (!(obj instanceof Enrollment)) {
            throw new IllegalArgumentException("Object is not of type Enrollment");
        }

        Enrollment enrollment = (Enrollment) obj;
        String sql = "INSERT INTO Enrollment (enrollmentID, studentID, courseID, enrollmentDate) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getEnrollmentID());
            preparedStatement.setInt(2, enrollment.getStudentID());
            preparedStatement.setInt(3, enrollment.getCourseID());
            preparedStatement.setDate(4, Date.valueOf(enrollment.getEnrollmentDate()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id, Object obj) throws SQLException {
        if (!(obj instanceof Enrollment)) {
            throw new IllegalArgumentException("Object is not of type Enrollment");
        }

        Enrollment enrollment = (Enrollment) obj;
        String sql = "UPDATE Enrollment SET studentID=?, courseID=?, enrollmentDate=? WHERE enrollmentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudentID());
            preparedStatement.setInt(2, enrollment.getCourseID());
            preparedStatement.setDate(3, Date.valueOf(enrollment.getEnrollmentDate()));
            preparedStatement.setInt(4, enrollment.getEnrollmentID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Enrollment WHERE enrollmentID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }


    public List<Enrollment> DisplayAll() throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int enrollmentID = resultSet.getInt("enrollmentID");
                int studentID = resultSet.getInt("studentID");
                int courseID = resultSet.getInt("courseID");
                LocalDate enrollmentDate = resultSet.getDate("enrollmentDate").toLocalDate();
                enrollments.add(new Enrollment(enrollmentID, studentID, courseID, enrollmentDate));
            }
        }
        return enrollments;
    }

    public List<Enrollment> getEnrollmentsByCourse(String courseName) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment WHERE courseID IN (SELECT courseID FROM Course WHERE courseName = ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, courseName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int studentID = resultSet.getInt("studentID");
                    // Retrieve other enrollment details as needed
                    enrollments.add(new Enrollment(studentID, courseName)); // Assuming constructor is available
                }
            }
        }
        return  enrollments;
    }

    public static void generateEnrollmentReport(String courseName) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Enrollment WHERE courseName = ?");
        preparedStatement.setString(1, courseName);
        ResultSet myResult = preparedStatement.executeQuery();
        System.out.println("Enrollment Report for Course: " + courseName);
        System.out.println("==============================================");
        System.out.println("Student ID\tEnrollment Date");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getStudentID() + "\t\t" + enrollment.getEnrollmentDate());
        }

    }

    public void insertEnrollment(Enrollment enrollment) {

    }
}
