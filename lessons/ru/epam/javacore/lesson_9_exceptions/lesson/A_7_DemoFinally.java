package ru.epam.javacore.lesson_9_exceptions.lesson;

public class A_7_DemoFinally {
    public static void main(String[] args) {
        // int divide = divide(10, 0);
        // System.out.println(divide);
        // a_2_divide(16,0);

        // a_3_divide(16, 0);
        //System.out.println(a_4_divide(115, 0));
        System.out.println(a_5_divide(115, 0));
    }


    private static int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            return -1;
        }
    }

    private static void a_2_divide(int a, int b) {
        try {
            int c = a / b;
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }
    }

    private static void a_3_divide(int a, int b) {
        try {
            int c = a / b;
            System.out.println("1");
        } finally {
            System.out.println("3");
        }
    }

    private static int a_4_divide(int a, int b) {
        try {
            int c = a / b;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    private static int a_5_divide(int a, int b) {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
