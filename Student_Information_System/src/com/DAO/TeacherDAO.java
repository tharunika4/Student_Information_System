package com.DAO;

import com.JdbcConnection.ConnectionFactory;
import com.data.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements Dao {

    @Override
    public void insert(Object obj) throws SQLException {
        if (!(obj instanceof Teacher)) {
            throw new IllegalArgumentException("Object is not of type Teacher");
        }

        Teacher teacher = (Teacher) obj;
        String sql = "INSERT INTO Teacher (teacherID, name, expertise, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teacher.getTeacherID());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setString(3, teacher.getExpertise());
            preparedStatement.setString(4, teacher.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id,Object obj) throws SQLException {
        if (!(obj instanceof Teacher)) {
            throw new IllegalArgumentException("Object is not of type Teacher");
        }

        Teacher teacher = (Teacher) obj;
        String sql = "UPDATE Teacher SET name=?, expertise=?, email=? WHERE teacherID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getExpertise());
            preparedStatement.setString(3, teacher.getEmail());
            preparedStatement.setInt(4, teacher.getTeacherID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Teacher WHERE teacherID=?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Teacher> DisplayAll() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM Teacher";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int teacherID = resultSet.getInt("teacherID");
                String firstName = resultSet.getString("name");
                String lastName = resultSet.getString("expertise");
                String email = resultSet.getString("email");
                teachers.add(new Teacher(teacherID, firstName, lastName, email));
            }
        }
        return teachers;
    }


}