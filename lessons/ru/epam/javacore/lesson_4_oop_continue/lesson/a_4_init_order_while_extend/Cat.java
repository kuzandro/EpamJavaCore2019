package ru.epam.javacore.lesson_4_oop_continue.lesson.a_4_init_order_while_extend;

public class Cat {
    static final int ID = getId();
    static {
        System.out.println("Cat static block");
    }
    protected String name = getName33();
    protected Integer age;

    public Cat() {
        System.out.println("Cat constructor");
    }

    private static int getId(){
        System.out.println("Cat static getId");
        return 1;
    }
    public String getName33(){
        System.out.println("Cat get name");
        return "Name";
    }

    public int getAge(){
        return 33;
    }


}
