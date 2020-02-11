package ru.epam.javacore.lesson_3_oop_continue.lesson.a_5_arrays;

public class ArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 34, 45};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
       // System.out.println(arr[4]);

        for (int i =0; i<arr.length; i++){
            System.out.println(arr[i]);

        }

    }

}
