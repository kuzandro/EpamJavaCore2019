package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_2_improvement_of_house;

public class Address {
    private String street;
    private int house;

    public Address(String street, int house) {
        this.street = street;
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }
}
