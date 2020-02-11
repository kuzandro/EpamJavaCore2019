package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_4_static_example;

public class Tank {
    private String name;
    private String country;
    private static String material = "Iron";

    public Tank(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public static void main(String[] args) {
        Tank tt = Tank.createTank("AA");
        Tank.createTank("AA");
        Tank.createTank("AA");
        Tank.createTank("AA");
        Tank.createTank("AA");

        Tank tank1 = new Tank("T-80", "Russia");


        System.out.println(tank1);
        Tank.setMaterial("Steel");
        System.out.println(tank1);

        Tank tank2 = new Tank("M1 Abrams", "USA");
        System.out.println(tank2);


        Tank tank3 = new Tank("Leopard2", "Germany");
        System.out.println(tank3);
    }

    static Tank createTank(String name) {
        return new Tank(name, "");
    }

    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaterial() {
        return material;
    }

    public static void setMaterial(String material) {
        Tank.material = material;
    }
}
