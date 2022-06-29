package com.vladislavgolovkin.vtb.Lesson2_AdvancedOOP;

public class Wall extends Obstacle{

    public Wall(int lengthObstacle) {
        super(lengthObstacle);
    }

    @Override
    boolean passingAllObstacles(AbleToJumpAbleToRun able) {
        return able.jump(lengthObstacle);
    }
}
