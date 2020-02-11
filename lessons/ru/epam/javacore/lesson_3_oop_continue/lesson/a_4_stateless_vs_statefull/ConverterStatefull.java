package ru.epam.javacore.lesson_3_oop_continue.lesson.a_4_stateless_vs_statefull;

public class ConverterStatefull {

    private int value;

    public ConverterStatefull(int value) {
        this.value = value;
    }

    public String convertToString() {
        return value + "";
    }

    public static void main(String[] args) {
        ConverterStatefull converter = new ConverterStatefull(33);
        String converted = converter.convertToString();
        System.out.println(converted);
        //
        //
    }
}
