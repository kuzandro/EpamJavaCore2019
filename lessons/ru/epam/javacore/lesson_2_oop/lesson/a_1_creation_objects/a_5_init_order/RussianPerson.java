package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_5_init_order;

public class RussianPerson {
    static {
        System.out.println("1 Static in action");
    }

    private static final float RATE = getRate();
    private float salaryAfterTax = calculateSalaryAfterTax();
    private int salary;
    private String name;
    private String lastName;
    private String fullName;
    private String fullAddress;

    {
        fullName = this.name + this.lastName;
        System.out.println("Init block");
    }

    static float getRate() {
        System.out.println("Get rate static");
        return 0.13f;
    }

    public static void main(String[] args) {
        RussianPerson russianPerson = new RussianPerson(1000);
        System.out.println(russianPerson);
    }

    public RussianPerson(int salary) {
        System.out.println("Constructor");
        this.salary = salary;
        // this.salaryAfterTax = calculateSalaryAfterTax();
    }

    private float calculateSalaryAfterTax() {
        System.out.println("BERFORE " + this.salaryAfterTax);
        System.out.println("Calc real salary");
        return (1 - RATE) * salary;
    }

    @Override
    public String toString() {
        return "RussianPerson{" +
                "salaryAfterTax=" + salaryAfterTax +
                ", salary=" + salary +
                ", fullName='" + fullName + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }


}
