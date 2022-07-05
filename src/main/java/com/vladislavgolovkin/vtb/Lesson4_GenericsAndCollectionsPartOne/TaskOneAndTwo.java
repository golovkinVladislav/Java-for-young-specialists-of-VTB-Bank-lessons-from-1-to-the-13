package com.vladislavgolovkin.vtb.Lesson4_GenericsAndCollectionsPartOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskOneAndTwo {
    public static void swapTwoElements(String [] strings, int index1, int index2){
        System.out.println("Before: " + Arrays.toString(strings));
        for(int i=0; i<strings.length; i++){
            if(i == index1){
                String temp = strings[i];
                strings[i] = strings[index2];
                strings[index2] = temp;
            }
        }
        System.out.println("After: " + Arrays.toString(strings));
    }
    public static <T> ArrayList<T> transformationsArrayToArrayList(T [] array){
            return new ArrayList<>(Arrays.asList(array));

    }
}
