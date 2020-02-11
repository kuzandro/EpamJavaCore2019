package ru.epam.javacore.lesson_7_collections_continue_map.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class A_1_list_contains_remove {

    public static void main(String[] args) {
        //a1_deleteFromCollection();
        // a2_demoDelete();
        //  a3_demoDelete();
        a4_demoContains();
    }

    private static void a1_deleteFromCollection() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        List<String> itemsToDelete = new ArrayList<>();

        for (String item : list) {
            if (Integer.parseInt(item) > 3) {
                itemsToDelete.add(item);
            }
        }

        list.removeAll(itemsToDelete);
        System.out.println();
    }

    private static void a2_demoDelete() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        list.remove(1);
        System.out.println(list);
    }

    private static void a3_demoDelete() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A"));
        Person b = new Person("B");
        list.add(b);
        list.add(new Person("C"));

        list.remove(new Person("B"));
        //list.remove(b);
        System.out.println(list);
    }

    private static void a4_demoContains() {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list.contains("1"));

        List<Person> persons = Arrays.asList(
                new Person("A"),
                new Person("B"),
                new Person("C")
        );

        System.out.println(persons.contains(new Person("B")));
    }

    private static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
