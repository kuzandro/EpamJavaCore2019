package ru.epam.javacore.lesson_10.lesson.a_4_wild_card;

import java.util.List;

public class A_1_List_Demo {

    private static <T> void printListContent(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    private static void printListContent2(List<?> list) {
        for (Object t : list) {
            System.out.println(t);
        }
    }



}
