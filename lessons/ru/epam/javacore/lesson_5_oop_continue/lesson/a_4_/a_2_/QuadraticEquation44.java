package ru.epam.javacore.lesson_5_oop_continue.lesson.a_4_.a_2_;

public class QuadraticEquation44 {
    private float a, b, c;
    private static int k = 99;

    private void calculate(){

    }

    private void calculate2(){

    }
    public void solve() {
        Discriminant44 discriminant = new Discriminant44();
        discriminant.calculate();

        switch (discriminant.howToSolve()){

            case ONE:
                break;
            case TWO:
                break;
            case NONE:
                break;
        }
    }

    public static class Discriminant44 {

        private float value;

        private static void test(){

        }

        private void calculate() {
            int i = QuadraticEquation44.k;
          //  QuadraticEquation44.this.calculate();
         //   calculate2();
         //   value = b * b - 4 * a * c;
        }

        private SolutionsWay howToSolve() {
            if (value > 0) {
                return SolutionsWay.TWO;
            } else if (value == 0) {
                return SolutionsWay.ONE;
            } else {
                return SolutionsWay.NONE;
            }
        }
    }

    private enum SolutionsWay {
        ONE, TWO, NONE
    }
}
