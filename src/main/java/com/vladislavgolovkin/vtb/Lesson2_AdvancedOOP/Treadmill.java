package com.vladislavgolovkin.vtb.Lesson2_AdvancedOOP;

public class Treadmill extends Obstacle {

    public Treadmill(int lengthObstacle) {
        super(lengthObstacle);
    }

    @Override
    boolean passingAllObstacles(AbleToJumpAbleToRun able) {
        return able.run(lengthObstacle);
    }
}
