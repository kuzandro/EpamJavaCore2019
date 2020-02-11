package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_3_box_unbox;

public class D {

    public static void main(String[] args) {
        int i1 = 5000;
        Integer i2 = 5000;
        i2 = null;
        int k = 0;
        if (i2 != null) {
            k = i2;
        }
        k++;


    }
}
