package ru.epam.javacore.lesson_3_oop_continue.lesson.a_3_not_workable_clonable;

public class City {

    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        City city = new City("Spb", 3000);
        City city2 = (City) city.clone();
    }
}
