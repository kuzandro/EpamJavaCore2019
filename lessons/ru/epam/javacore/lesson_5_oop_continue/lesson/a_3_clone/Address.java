package ru.epam.javacore.lesson_5_oop_continue.lesson.a_3_clone;

public class Address implements Cloneable{
    private String country;

    public Address(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                '}';
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return new Address(this.country);
    }
}
