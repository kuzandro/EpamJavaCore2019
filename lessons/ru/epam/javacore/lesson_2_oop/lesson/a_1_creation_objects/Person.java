package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private Integer snils;

    public Person(){
        System.out.println("Init person in action");
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Ivan");
        person.setLastName("Ivanov");
        person.setAge(20);

        if (person.getSnils() != null) {
            System.out.println("Come to nalog station, Baby!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSnils() {
        return snils;
    }

    public void setSnils(Integer snils) {
        this.snils = snils;
    }


}
