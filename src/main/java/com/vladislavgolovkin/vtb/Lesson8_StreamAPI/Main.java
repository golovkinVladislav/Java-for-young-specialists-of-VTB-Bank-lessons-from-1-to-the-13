package com.vladislavgolovkin.vtb.Lesson8_StreamAPI;
/* Практическое задание
1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
встречающееся;
2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
среднюю зарплату сотрудника;
3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
имя1, имя2, имяN;
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String [] strings = {"Cat","Cat","Dog","Dog","Cat","Tiger","Tiger"};
        Task1.searchForTheMostCommonWords(strings);


        Employee employee1 = new Employee("John",2000,45);
        Employee employee2 = new Employee("James",3400,26);
        Employee employee3 = new Employee("Jackson",2400,30);
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employee1,employee2,employee3));
        System.out.println(Employee.averageSalary(employeeList));


        Employee.theMostSeniorEmployees(employeeList,2);
    }
}
