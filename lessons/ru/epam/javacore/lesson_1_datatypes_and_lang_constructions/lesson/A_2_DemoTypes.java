package ru.epam.javacore.lesson_1_datatypes_and_lang_constructions.lesson;

public class A_2_DemoTypes {

    public static void main(String[] args) {
        // demoString_2();;
        //  demoCompare_3();
        demoLogicalOperations_4();
    }

    private static void demoPrimitives_1() {
        int a = 1;
        int b = 3;
        int c = a + b;
        boolean b2 = true;
        double d = 33.5;
        long r = 55;

        boolean vasya;

        vasya = true;
    }

    private static void demoNotPrimitives() {
        Integer a = 1;
        Integer b = 3;
        Integer c = a + b;
        Long r = 66L;

        Integer tt = null;
        tt.toString();
    }

    private static void demoString_2() {
        String s1 = "Hello";
        String s2 = "World";

        String result = s1 + " " + s2;
        System.out.println(result);
        System.out.println("Size " + result.length());

        String sum = "";
        sum = sum + " Ivan";
        sum = sum + " Dmitry";


        System.out.println(sum);
    }

    private static void demoCompare_3() {
        int a = 1;
        int b = 1;

        System.out.println(a == b);

        String s1 = "abc";
        String s2 = "abc";

        System.out.println("s1 == s2 " + (s1 == s2));

        String s3 = "cde";
        String s4 = new String("cde");
        System.out.println("s3 == s4 " + (s3 == s4));
        System.out.println("s3 eq s4 " + (s3.equals(s4)));

        Integer y = 5000;
        Integer y2 = 5000;

        System.out.println(y == y2);
    }


    private static void demoLogicalOperations_4() {
        //boolean hasPoison = dish1() && dish2() && dish3();
        boolean hasPoison = dish1() & dish2() & dish3();
        System.out.println(hasPoison);
    }

    private static boolean dish1() {
        System.out.println("dish 1");
        return true;
    }

    private static boolean dish2() {
        System.out.println("dish2");
        return false;
    }

    private static boolean dish3() {
        System.out.println("dish3");
        return false;
    }
}
