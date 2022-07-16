package com.vladislavgolovkin.vtb.Lesson7_MultithreadingPartTwo;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
