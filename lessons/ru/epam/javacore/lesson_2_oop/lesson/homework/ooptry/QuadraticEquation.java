package ru.epam.javacore.lesson_2_oop.lesson.homework.ooptry;

import static ru.epam.javacore.lesson_2_oop.lesson.homework.ooptry.Discriminant.NO_SOLUTIONS;
import static ru.epam.javacore.lesson_2_oop.lesson.homework.ooptry.Discriminant.ONE_SOLUTION;
import static ru.epam.javacore.lesson_2_oop.lesson.homework.ooptry.Discriminant.TWO_SOLUTIONS;

public class QuadraticEquation {
    private InputData inputData;

    public QuadraticEquation(InputData inputData) {
        this.inputData = inputData;
    }

    public OutputData resolve() {
        OutputData outputData = new OutputData();

        if (inputData.isInputDataValid()) {
            Discriminant discriminant = new Discriminant(inputData);
            discriminant.calculate();

            float a = inputData.getA();
            float b = inputData.getB();

            switch (discriminant.getStatus()) {
                case ONE_SOLUTION: {
                    outputData.setFirstSolution(-b / (2 * a));
                    break;
                }

                case TWO_SOLUTIONS: {
                    outputData.setFirstSolution((-b + discriminant.getSqrt()) / (2 * a));
                    outputData.setSecondSolution((-b - discriminant.getSqrt()) / (2 * a));
                    break;
                }

                case NO_SOLUTIONS: {
                    break;
                }
            }
        }
        return outputData;
    }

}
