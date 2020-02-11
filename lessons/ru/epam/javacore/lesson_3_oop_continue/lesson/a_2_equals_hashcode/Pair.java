package ru.epam.javacore.lesson_3_oop_continue.lesson.a_2_equals_hashcode;

import java.util.Objects;

public class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int hashCode() {
        return left + right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return left == pair.left &&
                right == pair.right;
    }

    public static void main(String[] args) {
        Pair p1 = new Pair(1, 2);
        System.out.println(p1.hashCode());

        Pair p2 = new Pair(2, 1);
        System.out.println(p2.hashCode());

        Pair p3 = new Pair(1, 2);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}
