package com.vladislavgolovkin.vtb.Lesson8_StreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public static void searchForTheMostCommonWords(String [] strings){
         Map<String, Long> countingAllTheElementsEncountered = Arrays.stream(strings)
                 .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        String theMostCommonWord =
                countingAllTheElementsEncountered.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getKey();
        Long HowManyTimesDidTheMostPopularWordOccurCommonWord =
                countingAllTheElementsEncountered.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getValue();
        System.out.println( "Встречается больше всего  слово: " + theMostCommonWord +
                " - оно встретилось " + HowManyTimesDidTheMostPopularWordOccurCommonWord + " раз(а)");
    }
}
