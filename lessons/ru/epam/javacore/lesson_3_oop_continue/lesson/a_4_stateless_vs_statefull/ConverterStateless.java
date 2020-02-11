package ru.epam.javacore.lesson_3_oop_continue.lesson.a_4_stateless_vs_statefull;

public class ConverterStateless {

    public String convertToString(int value) {
        return value + "";
    }

    public static void main(String[] args) {
        ConverterStateless converter = new ConverterStateless();
        String converted = converter.convertToString(33);

        System.out.println(converted);
    }
}
