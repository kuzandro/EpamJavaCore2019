package ru.epam.javacore.lesson_3_oop_continue.lesson.a_6_enums;

/**
 * | CODE |
 * -----------
 */
//RU
  //    GB

public enum Status {

    IN_PROGRESS(1, "Program is running"),
    FAILED(2, "Failed, because of exception");

    private int code;
    private String description;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
