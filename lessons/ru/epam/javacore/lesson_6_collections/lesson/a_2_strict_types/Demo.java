package ru.epam.javacore.lesson_6_collections.lesson.a_2_strict_types;

import ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.Person;

public class Demo {
    public static void main(String[] args) {

        Object[] objects = new Object[]{
                "one", "two", "three", 88, new Person()
        };
        printStringsLength((String[]) objects);
    }

    private static void printStringsLength(String[] strs) {
        System.out.println("SSSSSSSS");
        for (String s : strs) {
            System.out.println(s.length());
        }
    }
}
