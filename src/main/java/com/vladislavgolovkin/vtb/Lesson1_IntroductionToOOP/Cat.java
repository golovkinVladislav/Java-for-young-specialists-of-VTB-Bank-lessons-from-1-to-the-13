package com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP;

public class Cat extends Animal {
    private static final int restrictionsOnRunningActions = 200;
    static int countCreatedCat;

    public Cat() {
        countCreatedCat++;
    }

    @Override
    void run(int lengthObstacle) {
        if (lengthObstacle > restrictionsOnRunningActions) {
            System.out.println("Кот не может пробежать больше чем " + restrictionsOnRunningActions + " м.");
        }
        if (lengthObstacle <= 0) {
            System.out.println("Длина препятствия не может быть меньше или равно 0");
        }
        if (lengthObstacle <= restrictionsOnRunningActions && lengthObstacle > 0) {
            System.out.println("Кот пробежал " + lengthObstacle + " м.");
        }
    }

    @Override
    void swim(int lengthObstacle) {
        System.out.println("Кот не умеет плавать");
    }


}
