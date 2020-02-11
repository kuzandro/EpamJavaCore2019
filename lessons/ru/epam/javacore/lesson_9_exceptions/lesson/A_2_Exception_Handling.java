package ru.epam.javacore.lesson_9_exceptions.lesson;

import java.util.HashMap;
import java.util.Map;

public class A_2_Exception_Handling {
    public static void main(String[] args) {
       // a_showDivResultFail_ResolveException_1();
        a_showDivResultFail_ResolveException_2();
    }


    private static void a_showDivResultFail() {
        Map<Integer, Integer> params = new HashMap<>();
        params.put(1, 4);
        params.put(6, 0);
        params.put(8, 4);

        for (Map.Entry<Integer, Integer> entry : params.entrySet()) {
            showDivResult(entry.getKey(), entry.getValue());
        }
    }

    private static void a_showDivResultFail_ResolveException_1() {
        try {
            Map<Integer, Integer> params = new HashMap<>();
            params.put(1, 4);
            params.put(6, 0);
            params.put(8, 4);

            for (Map.Entry<Integer, Integer> entry : params.entrySet()) {
                showDivResult(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }

    private static void a_showDivResultFail_ResolveException_2() {

        Map<Integer, Integer> params = new HashMap<>();
        params.put(1, 4);
        params.put(6, 0);
        params.put(8, 4);

        for (Map.Entry<Integer, Integer> entry : params.entrySet()) {
            try {
                showDivResult(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("END");
    }

    private static void showDivResult(int a, int b) {
        System.out.println(String.format("%s/%s", a, b));
        int i = a / b;
    }
}
