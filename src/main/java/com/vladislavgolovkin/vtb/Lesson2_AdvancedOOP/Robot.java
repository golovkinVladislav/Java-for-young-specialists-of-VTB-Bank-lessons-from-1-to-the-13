package com.vladislavgolovkin.vtb.Lesson2_AdvancedOOP;

public class Robot implements AbleToJumpAbleToRun {
    private final static int restrictionsOnRunningActions = 10000;
    private final static int restrictionsOnJumpingActions = 20;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(int lengthObstacle) {
        if(lengthObstacle > restrictionsOnJumpingActions){
            System.out.println(getName() + " не смог перепрыгнуть");
            return false;
        }
        if (lengthObstacle <=0){
            System.out.println(getName() + " Препятствие не может быть меньше или равно 0");
            return false;

        }
        if(lengthObstacle<= restrictionsOnJumpingActions && lengthObstacle > 0){
            System.out.println(getName() + " смог перепрыгнуть ");
            return true;
        }
        return false;
    }

    @Override
    public boolean run(int lengthObstacle) {
        if(lengthObstacle > restrictionsOnRunningActions){
            System.out.println(getName() + " не смог пробежать дистанцию");
            return false;
        }
        if (lengthObstacle <=0) {
            System.out.println(getName() + " Препятсвие не может быть меньше или равно 0");
            return false;
        }
        if(lengthObstacle <= restrictionsOnRunningActions && lengthObstacle > 0){
            System.out.println(getName() + " смог пробежать дистанцию");
            return true;
        }
            return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
