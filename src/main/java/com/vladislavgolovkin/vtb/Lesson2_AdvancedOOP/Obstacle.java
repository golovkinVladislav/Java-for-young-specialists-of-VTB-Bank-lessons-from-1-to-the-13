package com.vladislavgolovkin.vtb.Lesson2_AdvancedOOP;

public abstract class Obstacle {
    int lengthObstacle;

    public Obstacle(int lengthObstacle) {
        this.lengthObstacle = lengthObstacle;
    }

    abstract boolean passingAllObstacles(AbleToJumpAbleToRun able);
}
