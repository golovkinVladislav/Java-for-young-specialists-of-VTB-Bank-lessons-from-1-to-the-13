package com.vladislavgolovkin.vtb.Lesson8_StreamAPI;


import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static Double averageSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .mapToInt(s -> s.salary)
                .average()
                .getAsDouble();
    }

    public static void theMostSeniorEmployees(List<Employee> employeeList, int N) {
        System.out.println(employeeList.stream()
                .sorted((o1, o2) -> {
                    return o2.age - o1.age;
                })
                .limit(N)
                .map(s -> s.name)
                .collect(Collectors.joining(",", N + " cамых старших сотрудников зовут ", ";")));
    }
}


