package com.vladislavgolovkin.vtb.Lesson5_CollectionsPartTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Практическое задание
1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
через консоль
 */
public class Main {
    public static void main(String[] args) {
        String [] strings = {"A","B","A","C","B","B","C","A","A"};
        HomeWorkTask1.uniqueWordsInTheArrayAndCountOfEachWord(strings);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addToPhoneNumberInPhoneBook("Ivanov",8911);
        phoneBook.addToPhoneNumberInPhoneBook("Ivanov",8922);
        phoneBook.addToPhoneNumberInPhoneBook("Ivanov",8933);
        phoneBook.addToPhoneNumberInPhoneBook("Petrov",8000);
        phoneBook.getListPhoneNumperByTheNameOfThePerson("Ivanov");

    }
}
