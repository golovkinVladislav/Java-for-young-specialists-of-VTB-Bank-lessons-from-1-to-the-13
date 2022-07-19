package com.vladislavgolovkin.vtb.Lesson9_ReflectionAPI_JDBC_BasicsPostgreSQL;

@Table(title = "employees")
public class Employee {
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
