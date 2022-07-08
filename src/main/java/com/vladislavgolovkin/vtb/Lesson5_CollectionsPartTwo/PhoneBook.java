package com.vladislavgolovkin.vtb.Lesson5_CollectionsPartTwo;

import java.util.*;

public class PhoneBook {
    private Map<String, List<Integer>> phoneBookMap;

    public PhoneBook() {
        phoneBookMap = new HashMap<>();
    }

    public void addToPhoneNumberInPhoneBook(String surname, int phone) {
        if (phoneBookMap.containsKey(surname)) {
            phoneBookMap.get(surname).add(phone);
        } else {
            phoneBookMap.put(surname, new ArrayList<>(Arrays.asList(phone)));
        }
    }
    public void getListPhoneNumperByTheNameOfThePerson(String surname){
        System.out.println(phoneBookMap.get(surname));
    }

}
