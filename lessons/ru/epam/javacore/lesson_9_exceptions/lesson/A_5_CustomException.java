package ru.epam.javacore.lesson_9_exceptions.lesson;

public class A_5_CustomException {

    private static class BadUserException extends Exception {
        private int totalClicks;

        public BadUserException(String message) {
            super(message);
        }
    }

}
