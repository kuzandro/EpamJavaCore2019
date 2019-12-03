package com.company;

public class Main {

    public static void main(String[] args) {
        resultEqt(1, 2,1);
        resultEqt(1, 24,88);
        resultEqt(25, 2,5.6f);
    }

    private static void resultEqt(float a, float b, float c) {
        System.out.println("Задано уравнение: \n" + a + "*xˆ2 + " + b + "*x + " + c);
        System.out.println("Корни:");

        float d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2 + "\n");
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x + "\n");
        } else {
            System.out.println("Корни невещественные \n");
        }
    }
}
