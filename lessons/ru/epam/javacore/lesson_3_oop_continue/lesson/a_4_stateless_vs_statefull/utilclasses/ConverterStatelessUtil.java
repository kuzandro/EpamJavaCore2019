package ru.epam.javacore.lesson_3_oop_continue.lesson.a_4_stateless_vs_statefull.utilclasses;

/**
 * -Don't create instances of it PLEEEEEEASE!
 * -Why?
 */
public class ConverterStatelessUtil {

    private ConverterStatelessUtil(){

    }

    public static String convertToString(int value) {
        return value + "";
    }


}
