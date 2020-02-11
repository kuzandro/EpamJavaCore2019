package ru.epam.javacore.lesson_3_oop_continue.lesson.a_2_equals_hashcode;

import java.util.Objects;

public class Phone {
    private String markName;
    private int price;
    private Country country;

    public Phone(String markName, int price, Country country) {
        this.markName = markName;
        this.price = price;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return price == phone.price &&
                Objects.equals(markName, phone.markName) &&
                Objects.equals(country, phone.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markName, price, country);
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("IPhone", 33, new Country("USA"));
        System.out.println(phone1.hashCode());
        phone1.price=9999;
        Phone phone2 = new Phone("IPhone", 33, new Country("USA"));
        Phone phone3 = new Phone("Samsung", 44, new Country("Korea"));

        phone1.equals(phone2);

        System.out.println(phone1.equals(phone2));
        System.out.println(phone2 == phone3);
        System.out.println(phone1.hashCode());
    }

    private static class Country{
        private String name;

        public Country(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return Objects.equals(name, country.name);
        }


    }
}
