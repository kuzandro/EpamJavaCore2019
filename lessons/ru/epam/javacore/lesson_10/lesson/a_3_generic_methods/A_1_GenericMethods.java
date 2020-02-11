package ru.epam.javacore.lesson_10.lesson.a_3_generic_methods;

import java.util.ArrayList;

public class A_1_GenericMethods<A33, B> {
    private String name;
    private A33 a;

    public <A, Zu> A genericMethod(A t, Zu zu) {
        return t;
    }

    public static <A, Zu> A genericMethodStatic(A t, Zu zu) {
        return t;
    }

    public static void main(String[] args) {
        genericMethodStatic("S",1);
        genericMethodStatic(true,new ArrayList<>());
    }
}
