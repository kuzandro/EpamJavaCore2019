package ru.epam.javacore.lesson_7_collections_continue_map.lesson.map;

import java.util.HashMap;
import java.util.Map;

public class A_HashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 33);

        map.put("orange", 800);
        map.put("orange", 800);
        map.put("orange", 900);

        map.put("banana", 90);


        Integer one = map.get("apple");
        //System.out.println(one);

        System.out.println(88 % 32);

    }

}
