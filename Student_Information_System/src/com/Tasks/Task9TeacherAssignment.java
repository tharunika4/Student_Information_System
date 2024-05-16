package com.Tasks;

import com.DAO.CourseDAO;
import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.DAO.TransactionManager;
import com.data.*;
import java.sql.SQLException;

public class Task9TeacherAssignment {
    public static void main(String[] args) throws SQLException {

        // Create instances of DAO classes
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        TransactionManager transactionManager = new TransactionManager();
        CourseDAO courseDAO = new CourseDAO();

//        teacherDAO.delete(402);
//        courseDAO.delete(203);

        // Create a new teacher
        Teacher teacher1 = new Teacher(402, "Sarah Smith", "Mathematics", "smith@example.com");
        try {
            // Insert the teacher data into the database
            teacherDAO.insert(teacher1);
            System.out.println("Teacher data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting teacher data: " );
        }

        // Create a new course
        Course course = new Course(203," Advanced Database Management","CS302","Julia");
        try {
            // Insert the course data into the database
            courseDAO.insert(course);
            System.out.println("Course data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting course data: " );
        }

        Course course2 = new Course(204, ": Computer Science 101", "CS101", "Johnson");
        try {
            // Insert the course data into the database
            courseDAO.insert(course2);
            System.out.println("Course data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting course data: ");
        }

        // Retrive course based on coursecode
        String courseCode = "CS302";
        Course courseToUpdate = null;
        try {
            courseToUpdate = courseDAO.getCourseByCourseCode(courseCode);
            System.out.println(courseToUpdate);
        } catch (SQLException e) {
            System.out.println("Failed to retrieve course record: " + e.getMessage());
            e.printStackTrace();
            return; // Exit the program if retrieval fails
        }
        if (courseToUpdate == null) {
            System.out.println("Course with course code " + courseCode + " not found.");
            return; // Exit the program if course is not found
        }

        // Assign Sarah Smith as the instructor for the course
        transactionManager.assignInstructorToCourse(course,teacher1);
        System.out.println("Assigned course to teacher successfully.");


        // Update data in course
        try {
            courseDAO.update(203, teacher1);
            System.out.println("Course record updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update course record: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
