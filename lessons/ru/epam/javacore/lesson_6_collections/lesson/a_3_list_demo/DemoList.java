package ru.epam.javacore.lesson_6_collections.lesson.a_3_list_demo;

import java.util.*;

public class DemoList {
    public static void main(String[] args) {
        // demoIterator();
        // demoDeleteAddElementThrowError();
       // demoDeleteAddElementErrorWhileIterate();
        //demoDeleteAddElementWhileIterate();
    }

    private static void createList() {
        List<String> list = new ArrayList<>();
        List<String> linkedList = new LinkedList<String>();
    }

    private static void demoFillList() {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Dima");
        names.add("Peter");

        List<String> names2 = new ArrayList<>(names);

        List<String> names3 = Arrays.asList("one", "two", "three");
    }

    private static void demoIterateCollection() {
        List<String> names3 = Arrays.asList("one", "two", "three");
        for (int i = 0; i < names3.size(); i++) {
            System.out.println(names3.get(i));
        }

        List<String> names = new LinkedList<>();
        names.add("Ivan");
        names.add("Dima");
        names.add("Peter");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void demoIterator() {
        List<String> names = new LinkedList<>();
        names.add("1");
        names.add("2");
        names.add("3");
        names.add("4");
        names.add("5");
        names.add("6");
        names.add("7");

        Iterator<String> iterator = names.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            i++;
            String next = iterator.next();
            if (i != 0 && i % 2 == 0) {
                System.out.println(next);
            }
        }
    }

    private static void demoDeleteAddElementThrowError() {
        List<String> names = Arrays.asList("1", "2", "3");
        names.add("SSS");
        names.remove("2");
    }

    private static void demoDeleteAddElementErrorWhileIterate() {
        List<String> names =
                new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        names.add("SSS");
        names.remove("2");

        for (String name : names) {
            if ("4".equals(name)) {
                names.remove(name);
            }
        }
    }

    private static void demoDeleteAddElementWhileIterate() {
        List<String> names =
                new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        names.add("SSS");
        names.remove("2");

       Iterator<String> iter = names.iterator();
       while (iter.hasNext()){
           String value = iter.next();

           if (value.equals("4")){
               iter.remove();
           }
       }

        System.out.println(names);
    }

}
