package com.vladislavgolovkin.vtb.Lesson5_CollectionsPartTwo;

import java.util.*;

public class HomeWorkTask1 {
    public static void uniqueWordsInTheArrayAndCountOfEachWord(String [] strings){
        Set<String> set = new HashSet<>(Arrays.asList(strings));
        System.out.println(set);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], (map.get(strings[i])) + 1);
            } else map.put(strings[i], 1);
        }
        System.out.println(map);
    }
}
