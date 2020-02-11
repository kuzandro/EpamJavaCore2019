package ru.epam.javacore.lesson_8_collections_map_set_comparators.lesson.a_1_map_continue;

import java.util.LinkedHashMap;
import java.util.Map;

public class A_2_DemoOrdering {
    static class Person {

    }
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");

//        Map<Person, String> personMap = new TreeMap<>();
//        personMap.put(new Person(),"!!");
//        personMap.put(new Person(),"22");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
