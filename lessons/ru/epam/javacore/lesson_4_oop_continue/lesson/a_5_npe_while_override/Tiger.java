package ru.epam.javacore.lesson_4_oop_continue.lesson.a_5_npe_while_override;

public class Tiger extends Cat {
    static final int ID = getId();
    static {
        System.out.println("Tiger static block");
    }
    protected String name = getName();

    {
        age = getAge();
    }

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

    public Integer getAge(){
        return null;
    }
}
