package ru.epam.javacore.lesson_4_oop_continue.lesson.a_6_ovverride;

public class Apple extends Fruit {

    @Override
    public void washMe() {
        System.out.println("AAAA");
    }

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();

        Fruit[] fruits = new Fruit[]{apple, banana};
        for (Fruit fruit: fruits){
            fruit.washMe();
        }
    }
}
