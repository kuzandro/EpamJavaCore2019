package ru.epam.javacore.lesson_9_exceptions.lesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class A_3_Demo_CheckedExceptions {

    public static void main(String[] args) {

    }

    private static void a_1_readFile() {
        try {
            File file = new File("Any");
            BufferedReader reader = new BufferedReader(
                    new FileReader(file)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a_2_readFiles() {
        List<String> files = Arrays.asList("1", "2");
        try {
            for (String file : files) {
                a_2_readFile(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a_2_readFile(String filePath) throws Exception {
        File file = new File("Any");
        BufferedReader reader = new BufferedReader(
                new FileReader(file)
        );
    }



}


