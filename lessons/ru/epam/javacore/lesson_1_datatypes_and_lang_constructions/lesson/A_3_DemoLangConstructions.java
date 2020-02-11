package ru.epam.javacore.lesson_1_datatypes_and_lang_constructions.lesson;

public class A_3_DemoLangConstructions {

    public static void main(String[] args) {
        //demoIf_1();
        //demoIfElse_2();
        // demoIfElse_multi_3();
        //  demoIfElse_switch_No_break_4();
        // demoIfElse_switch_with_break_5();
        //  demoForLoop();
        // demoWhileLoop();
        demoDoWhileLoop();
    }

    private static void demoIf_1() {
        String s = "";
        Boolean f = null;

        if (s.isEmpty()) {
            System.out.println("String is empty");
        }
    }

    private static void demoIfElse_2() {
        String s = "s";
        if (s.isEmpty()) {
            System.out.println("String is empty");
        } else {
            System.out.println("String is not empty");
        }
    }


    private static void demoIfElse_multi_3() {

        int a = 666;

        if (a == 1) {
            System.out.println("1");
        } else if (a == 2) {
            System.out.println("2");
        } else if (a == 3) {
            System.out.println("3");
        } else {
            System.out.println("Any");
        }

    }

    private static void demoIfElse_switch_No_break_4() {
        int a = 1;
        switch (a) {
            case 1: {
                System.out.println("1");
            }
            case 2: {
                System.out.println("2");
            }
            case 3: {
                System.out.println("3");
            }
            default: {
                System.out.println("Any");
            }
        }
    }

    private static void demoIfElse_switch_with_break_5() {
        int a = 1;

        switch (a) {
            case 1: {
                System.out.println("1");
                break;
            }
            case 2: {
                System.out.println("2");
                break;
            }
            case 3: {
                System.out.println("3");
                break;
            }
            default: {
                System.out.println("Any");
            }
        }
    }

    private static void demoForLoop() {
        int result = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            result += 1;
        }

        System.out.println("Result " + result);
    }

    private static void demoWhileLoop() {
        int result = 0;

        while (result != 10) {
            System.out.println(result);
            result += 1;
        }

        System.out.println("Result " + result);
    }

    private static void demoDoWhileLoop() {
        int result = 0;

        do {
            System.out.println(result);
            result += 1;
        }
        while (result < 10);

        System.out.println("Result " + result);
    }

    private static void resolveAcq(float a, float b, float c){

    }

   // javaCoreEpam2019

}
