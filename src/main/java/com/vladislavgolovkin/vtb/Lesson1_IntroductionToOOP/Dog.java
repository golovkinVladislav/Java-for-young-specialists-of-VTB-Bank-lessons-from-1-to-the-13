package com.vladislavgolovkin.vtb.Lesson1_IntroductionToOOP;

public class Dog extends Animal {
    private static final int restrictionsOnRunningActions = 500;
    private static final int restrictionsOnSwimmingActions = 10;
    static int countCreatedDog;

    public Dog() {
        countCreatedDog++;
    }

    @Override
    void run(int lengthObstacle) {
        if (lengthObstacle > restrictionsOnRunningActions) {
            System.out.println("Собака не может пробежать больше чем " + restrictionsOnRunningActions + " м.");
        }
        if (lengthObstacle <= 0) {
            System.out.println("Длина препятствия не может быть меньше или равно 0");
        }
        if (lengthObstacle <= restrictionsOnRunningActions && lengthObstacle > 0) {
            System.out.println("Собака пробежала " + lengthObstacle + " м.");
        }
    }

    @Override
    void swim(int lengthObstacle) {
        if (lengthObstacle > restrictionsOnSwimmingActions) {
            System.out.println("Собака не может проплыть больше чем " + restrictionsOnSwimmingActions + " м.");
        }
        if (lengthObstacle <= 0) {
            System.out.println("Длина препятствия не может быть меньше или равно 0");
        }
        if (lengthObstacle <= restrictionsOnSwimmingActions && lengthObstacle > 0) {
            System.out.println("Собака проплыла " + lengthObstacle + " м.");
        }
    }

}
