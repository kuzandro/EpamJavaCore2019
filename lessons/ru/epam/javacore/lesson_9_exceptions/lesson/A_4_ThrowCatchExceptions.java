package ru.epam.javacore.lesson_9_exceptions.lesson;

import java.io.IOException;

public class A_4_ThrowCatchExceptions {

    public static void main(String[] args) {
        a_1_divideElements(1, 4);
        try {
            a_2_notRuntimeExceptions(9, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a_1_divideElements(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Bad arguments!");
        }
        int c = a / b;
    }

    private static void a_2_notRuntimeExceptions(int a, int b)
            throws Exception {
        throw new Exception("sss");
    }

    private static void a_3_several_exceptions() {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new RuntimeException("Error_1");
            }
            if (System.currentTimeMillis() % 3 == 0) {
                throw new IOException("Error_1");
            }

            if (System.currentTimeMillis() % 4 == 0) {
                throw new Exception("Error_1");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a_4_several_exceptions() throws IOException,
            Exception {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new RuntimeException("Error_1");
        }

        if (System.currentTimeMillis() % 3 == 0) {
            throw new IOException("Error_1");
        }

        if (System.currentTimeMillis() % 4 == 0) {
            throw new Exception("Error_1");
        }
    }
}
