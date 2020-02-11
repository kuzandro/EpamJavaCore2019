package ru.epam.javacore.lesson_4_oop_continue.lesson.a_5_npe_while_override;

public class Cat {
    static final int ID = getId();
    static {
        System.out.println("Cat static block");
    }
    protected String name = getName33();
    protected Integer age = this.getAge();
    {
        System.out.println(age++);
    }

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

    public Integer getAge(){
        System.out.println("AGE!!!!!!!!!!");
        return 33;
    }

}
