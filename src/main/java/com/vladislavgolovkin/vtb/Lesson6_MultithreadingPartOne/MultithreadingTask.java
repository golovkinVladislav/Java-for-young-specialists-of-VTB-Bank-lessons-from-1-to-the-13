package com.vladislavgolovkin.vtb.Lesson6_MultithreadingPartOne;

public class MultithreadingTask {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void TimeCountingMethodWithoutMultithreading() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void TimeCountingWithMultithreadingMethod() {
        float[] arr = new float[SIZE];
        float[] destination1 = new float[HALF];
        float[] destination2 = new float[HALF];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, destination1, 0, HALF);
        System.arraycopy(arr, HALF, destination2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < destination1.length; i++) {
                destination1[i] = (float) (destination1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < destination2.length; i++) {
                destination2[i] = (float) (destination2[i] * Math.sin(0.2f + (i+HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) *
                        Math.cos(0.4f + (i+HALF) / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(destination1, 0, arr, 0, HALF);
        System.arraycopy(destination2, 0, arr, HALF, HALF);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
