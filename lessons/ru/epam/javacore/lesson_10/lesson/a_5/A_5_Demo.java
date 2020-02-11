package ru.epam.javacore.lesson_10.lesson.a_5;

import java.util.ArrayList;
import java.util.List;

public class A_5_Demo {
    static class Person {
    }

    static class YoungPerson extends Person {
    }

    static class ElderPerson extends Person {
    }

    public static void main(String[] args) {
        buyTickets(new ArrayList<ElderPerson>());
        buyTickets(new ArrayList<YoungPerson>());
    }

    private static <T extends Person> void
    buyTickets(List<T> persons) {
        System.out.println(persons.getClass());
    }
}
