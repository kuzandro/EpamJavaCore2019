package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_2_improvement_of_house;

public class Owner {
    private String name;
    private String lastName;

    public Owner(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
