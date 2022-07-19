package com.vladislavgolovkin.vtb.Lesson9_ReflectionAPI_JDBC_BasicsPostgreSQL;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/*
1. Реализуйте возможность разметки класса с помощью набора ваших собственных аннотаций
(@Table(title), @Column). Напишите обработчик аннотаций, который позволит по размеченному
классу построить таблицу в базе данных.
2. * Второй обработчик аннотаций должен уметь добавлять объект размеченного класса в
полученную таблицу
Замечание: Считаем что в проекте не связанных между собой сущностей, чтобы не
продумывать логику их взаимодействия
 */
public class Main {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/lesson9";
    private static final String USER = "postgres";
    private static final String PASS = "admin";
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Successfully connected to database now");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableUsingTheAnnotationHandler(Class cl) {
        //CREATE TABLE employees (id INTEGER, name TEXT, department TEXT);
        if (!cl.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("The annotation does not exist");
        }
        Map<Class, String> map = new HashMap<>();
        map.put(int.class, "INTEGER");
        map.put(String.class, "TEXT");
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(((Table) cl.getAnnotation(Table.class)).title()).append(" (");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)) {
                stringBuilder.append(field.getName()).append(" ").append(map.get(field.getType()))
                        .append(", ");
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(");");
        try {
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertIntoTableUsingTheAnnotationHandler(Class cl) {
        //INSERT INTO employees (id,name,department) VALUES (?, ?, ?);
        if (!cl.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("The annotation does not exist");
        }
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO ").append(((Table) cl.getAnnotation(Table.class)).title())
                .append(" (");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)) {
                stringBuilder.append(field.getName()).append(",");
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(") VALUES ").append("(?,").append(" ?,").append(" ?)").append(";");
        try {
            preparedStatement = connection.prepareStatement(stringBuilder.toString());
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Johnson");
            preparedStatement.setString(3, "IT");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            connect();
            createTableUsingTheAnnotationHandler(Employee.class);
            insertIntoTableUsingTheAnnotationHandler(Employee.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
}
