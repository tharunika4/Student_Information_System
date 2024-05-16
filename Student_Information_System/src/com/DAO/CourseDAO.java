package com.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.JdbcConnection.ConnectionFactory;
import com.data.Course;
import com.data.Teacher;


public class CourseDAO implements Dao {

    @Override
    public void insert(Object obj) throws SQLException {
        if (!(obj instanceof Course)) {
            throw new IllegalArgumentException("Object is not of type Course");
        }

        Course course = (Course) obj;
        String sql = "INSERT INTO Course (courseID, courseName, courseCode, instructorName) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setString(3, course.getCourseCode());
            preparedStatement.setString(4, course.getInstructorName());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id,Object obj) throws SQLException {
        if (!(obj instanceof Teacher))  {
            throw new IllegalArgumentException("Object is not of type Course");
        }

        Course course = new Course();
        Teacher teacher = (Teacher) obj;
        String sql = "UPDATE Course SET courseName=?, courseCode=?, instructorName=? WHERE courseID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getCourseCode());
            preparedStatement.setString(3, teacher.getName());
            preparedStatement.setInt(4, course.getCourseID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Course WHERE courseID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Course> DisplayAll() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int courseID = resultSet.getInt("courseID");
                String courseName = resultSet.getString("courseName");
                String courseCode = resultSet.getString("courseCode");
                String instructorName = resultSet.getString("instructorName");
                courses.add(new Course(courseID, courseName, courseCode, instructorName));
            }
        }
        return courses;
    }

    public Course getCourseByCourseCode(String courseCode) throws SQLException {
        String sql = "SELECT * FROM Course WHERE courseCode = ?";
        Course course = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, courseCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int courseID = resultSet.getInt("courseID");
                    String courseName = resultSet.getString("courseName");
                    String instructorName = resultSet.getString("instructorName");
                    course = new Course(courseID, courseName, courseCode, instructorName);
                }
            }
        }
        return course;
    }

    public void assignInstructorToCourse(int courseID, String instructorName, String email) {
        String sql = "UPDATE Course SET instructorName = ? WHERE courseID = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, instructorName);
            preparedStatement.setInt(2, courseID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}


