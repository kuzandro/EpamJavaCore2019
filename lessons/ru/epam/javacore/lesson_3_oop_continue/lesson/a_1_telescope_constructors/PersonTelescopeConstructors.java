package ru.epam.javacore.lesson_3_oop_continue.lesson.a_1_telescope_constructors;

public class PersonTelescopeConstructors {
    private String name;
    private String lastName;
    private int age;

    public PersonTelescopeConstructors(String name){
        this.name = name;
    }

    public PersonTelescopeConstructors(String name, String lastName){
        this(name);
        this.lastName = lastName;
    }

    public PersonTelescopeConstructors(String name, String lastName, int age) {
        this(name, lastName);
        this.age = age;
    }
}
