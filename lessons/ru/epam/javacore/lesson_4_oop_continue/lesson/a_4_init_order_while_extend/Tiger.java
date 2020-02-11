package ru.epam.javacore.lesson_4_oop_continue.lesson.a_4_init_order_while_extend;

public class Tiger extends Cat {
    static final int ID = getId();
    static {
        System.out.println("Tiger static block");
    }
    protected String name = getName();
    protected Integer age;

    public Tiger() {
        System.out.println("Tiger constructor");
    }

    private static int getId(){
        System.out.println("Tiger static getId");
        return 1;
    }
    public String getName(){
        System.out.println("Tiger get name");
        return "Name";
    }
}
