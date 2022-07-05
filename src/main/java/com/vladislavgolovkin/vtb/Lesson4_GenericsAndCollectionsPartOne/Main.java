package com.vladislavgolovkin.vtb.Lesson4_GenericsAndCollectionsPartOne;

import java.util.ArrayList;
import java.util.List;

/* Практическое задание
1. Написать метод, который меняет два элемента массива местами (массив может быть любого
ссылочного типа).
2. Написать метод, который преобразует массив в ArrayList.
3. Задача:
a. Даны классы Fruit -> Apple, Orange.
b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.
c. Для хранения фруктов внутри коробки можно использовать ArrayList.
d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного
фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
важны).
e. Внутри класса Box написать метод Compare, который позволяет сравнить текущую
коробку с той, которую подадут в Compare в качестве параметра. True, если их массы
равны, False — в противном случае. Можно сравнивать коробки с яблоками и
апельсинами.
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
объекты, которые были в первой.
g. Не забываем про метод добавления фрукта в коробку
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("task 1: ");
        String [] strings = {"a","b","c","d","f","g"};
        TaskOneAndTwo.swapTwoElements(strings,4,1);
        System.out.println("task 2: ");
        System.out.println(TaskOneAndTwo.transformationsArrayToArrayList(strings).size());
        System.out.println("task 3: ");
        Box<Apple> appleBox = new Box<>(new Apple(),new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(),new Orange());
        Box<Fruit> fruitBox = new Box<>();
        System.out.println(appleBox.compare(orangeBox));
        appleBox.transfer(fruitBox);







    }
}
