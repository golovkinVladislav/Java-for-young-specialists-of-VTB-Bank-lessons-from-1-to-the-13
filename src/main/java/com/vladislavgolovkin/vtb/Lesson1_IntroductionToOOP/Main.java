package com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP;

/* Практическое задание
        1. Создать классы Собака, Домашний Кот, Тигр, Животное (можете добавить два-три своих
        класса).
        2. Животные могут бежать и плыть. В качестве аргумента каждому методу передается длина
        препятствия.
        3. У каждого животного есть ограничения на действия (бег: кот — 200 м, собака — 500 м;
        плавание: кот — не умеет плавать, собака — 10 м). Результатом выполнения действия будет
        печать в консоль. Например: dogBobik.run(150); -> 'Бобик пробежал 150 м'.
        4. Создать один массив с животными и заставляете их по очереди пробежать дистанцию и
        проплыть.
        5. * Добавить подсчет созданных Домашних Котов, Тигров, Собак, Животных.  */


import static com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP.Animal.countAnimal;
import static com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP.Cat.countCreatedCat;
import static com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP.Dog.countCreatedDog;
import static com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP.Tiger.countCreatedTiger;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat(), new Dog(), new Cat(), new Tiger()};
        for (Animal animal : animals) {
            animal.run(500);
            animal.swim(10);
        }
        System.out.println("Котов создано = " + countCreatedCat + " Собак создано = " + countCreatedDog +
                " Тигров создано = " + countCreatedTiger + "; Всего животных создано = " + countAnimal);

    }
}
