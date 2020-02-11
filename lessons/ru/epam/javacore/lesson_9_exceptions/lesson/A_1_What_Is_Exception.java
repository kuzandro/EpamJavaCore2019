package ru.epam.javacore.lesson_9_exceptions.lesson;

public class A_1_What_Is_Exception {

    public static void main(String[] args) {
       // a_1_demoSimpleException();
        a_4_demoSimpleException();
    }

    private static void a_1_demoSimpleException(){
        int arr[] = new int[]{1};
        arr[99] = 100;
    }

    private static void a_2_demoSimpleException(){
        a_1_demoSimpleException();
    }
    private static void a_3_demoSimpleException(){
        a_2_demoSimpleException();
    }
    private static void a_4_demoSimpleException(){
        a_3_demoSimpleException();
    }

}
