package ru.epam.javacore.lesson_4_oop_continue.lesson.a_3_visibility;

public class DemoVisibility {

    public static void main(String[] args) {
        Person person = new Person();
       // person.name = "AAAA";
        person.setName("AAA");
        person.lastName = "Last name";

        Dog dog = new Dog();
        dog.name = "Woughw";
        dog.f();;
    }
}
