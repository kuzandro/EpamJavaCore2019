package ru.epam.javacore.lesson_10.lesson.a_2_generic_box;

public class A_1_GenericBox<Type> {
    private Type content;

    public A_1_GenericBox(Type content) {
        this.content = content;
    }

    public Type getContent() {
        return content;
    }

    public static void main(String[] args) {
        A_1_GenericBox<String> box = new A_1_GenericBox<>("String");
        A_1_GenericBox<Integer> boxInt = new A_1_GenericBox<>(333);

        String s = box.content;
        int i = boxInt.content;
    }
}
