package ru.epam.javacore.lesson_5_oop_continue.lesson.a_4_.a_1_inner;

public class QuadraticEquation {
    private float a, b, c;

    private void calculate(){

    }

    private void calculate2(){

    }
    public void solve() {
        Discriminant33 discriminant = new Discriminant33();
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

    public class Discriminant33 {
        private float value;

        private void calculate() {
            QuadraticEquation.this.calculate();
            calculate2();
            value = b * b - 4 * a * c;
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
