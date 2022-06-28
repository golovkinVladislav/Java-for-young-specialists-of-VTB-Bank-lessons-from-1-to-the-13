package com.vladislavgolovkin.vtb.Lesson1;

public class Tiger extends Animal {
    private static final int restrictionsOnRunningActions = 800;
    private static final int restrictionsOnSwimmingActions = 100;
    static int countCreatedTiger;

    public Tiger() {
        countCreatedTiger++;
    }

    @Override
    void run(int lengthObstacle) {
        if (lengthObstacle > restrictionsOnRunningActions) {
            System.out.println("Тигр не может пробежать больше чем " + restrictionsOnRunningActions + " м.");
        }
        if (lengthObstacle <= 0) {
            System.out.println("Длина препятствия не может быть меньше или равно 0");
        }
        if (lengthObstacle <= restrictionsOnRunningActions  && lengthObstacle > 0) {
            System.out.println("Тигр пробежал " + lengthObstacle + " м.");
        }
    }

    @Override
    void swim(int lengthObstacle) {
        if (lengthObstacle > restrictionsOnSwimmingActions) {
            System.out.println("Тигр не может проплыть больше чем " + restrictionsOnSwimmingActions + " м.");
        }
        if (lengthObstacle <= 0) {
            System.out.println("Длина препятствия не может быть меньше или равно 0");
        }
        if (lengthObstacle <= restrictionsOnSwimmingActions  && lengthObstacle > 0) {
            System.out.println("Тигр проплыл " + lengthObstacle + " м.");
        }
    }


}
