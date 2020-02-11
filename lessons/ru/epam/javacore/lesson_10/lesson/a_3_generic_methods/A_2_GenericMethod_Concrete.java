package ru.epam.javacore.lesson_10.lesson.a_3_generic_methods;

import java.io.Serializable;

public class A_2_GenericMethod_Concrete {

    public static <T extends Comparable<T>
            & Serializable>
    void compareAndSend(T t1, T t2) {
        int result = t1.compareTo(t2);

        T smallest = null;
        if (result > 0) {
            smallest = t2;
        } else if (result < 0) {
            smallest = t1;
        } else {
            throw new RuntimeException("Oops!");
        }

        //
        System.out.println(smallest);

    }

// public static <T extends Comparable<T>
//            & Serializable,
//         T2 extends Comparable<T2>
//                 & Serializable>
//    void compareAndSend2(T t1, T2 t2) {
//        int result = t1.compareTo(t2);
//
//        T smallest = null;
//        if (result > 0) {
//            smallest = t2;
//        } else if (result < 0) {
//            smallest = t1;
//        } else {
//            throw new RuntimeException("Oops!");
//        }
//
//        //
//        System.out.println(smallest);
//
//    }

    public static void main(String[] args) {
        compareAndSend("ss", "ss");
        compareAndSend(1, 33);
//        compareAndSend2("sdsdsd", 33);
    }
}
