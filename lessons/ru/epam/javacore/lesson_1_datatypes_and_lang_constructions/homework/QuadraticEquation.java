package ru.epam.javacore.lesson_1_datatypes_and_lang_constructions.homework;

public class QuadraticEquation {

    public static void main(String[] args) {
       /* boolean canManBuyWeapon = age> 21
                && medicineAttribute == FINE
                && amountOfMoney > 100;

        if (canManBuyWeapon){

        }*/

        System.out.println();
        int i = 9;
        if (i >= 9) {
            System.out.println("Hello");
            System.out.println("DDD");
        }

    }

    private static void resolveEquation(float a, float b, float c) {
        float discriminant = calculateDiscriminant(a, b, c);
        boolean hasRealSolutions = discriminant >= 0;

        if (hasRealSolutions) {
            calculateSolutions(a, b, c, discriminant);
        } else {
            System.out.println("No solutions");
        }
    }

    private static void calculateSolutions(float a, float b, float c, float discriminant) {

    }

    private static float calculateDiscriminant(float a, float b, float c) {
        return b * b - 4 * a * c;
    }

    private static void resolve(float a, float b, float c) {
        float d = 0;

        if (d > 0) {

        } else if (d == 0) {

        } else if (d < 0) {

        }
    }
}
