package org.example.jpa;

import org.example.jpa.domain.Student;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTableForStudent();

        Student marcin = new Student(1, "Marcin");
        Student kasia = new Student(2, "Kasia");
        insertStudent(marcin);
        insertStudent(kasia);

        List<Student> students = getStudent();

        students.forEach(System.out::println);

    }

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();

        String createTable = "CREATE TABLE STUDENT(id int primary key, name varchar(255))";

        statement.execute(createTable);

        connection.commit();
    }

    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();

        String insert = "INSERT INTO STUDENT VALUES("+student.getId()+",\'"+student.getName()+"\')";
        statement.execute(insert);
        connection.commit();
    }
    private static List<Student> getStudent() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            students.add(new Student(id,name));
        }
        return students;
    }
}
