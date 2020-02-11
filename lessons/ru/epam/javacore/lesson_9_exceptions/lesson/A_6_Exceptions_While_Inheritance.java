package ru.epam.javacore.lesson_9_exceptions.lesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A_6_Exceptions_While_Inheritance {

    public static void main(String[] args) {
        List<FileWriter> fileWriters = new ArrayList<>();
        fileWriters.add(new FileWriter());
        fileWriters.add(new ChildFileWriter());

        for (FileWriter fileWriter : fileWriters) {
            try {
                fileWriter.writeToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class FileWriter {
        public void writeToFile() throws IOException {
        }
    }

    public static class ChildFileWriter extends FileWriter {
        @Override
        public void writeToFile() {

        }
    }
}
