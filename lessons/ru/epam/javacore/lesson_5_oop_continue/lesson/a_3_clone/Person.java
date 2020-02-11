package ru.epam.javacore.lesson_5_oop_continue.lesson.a_3_clone;

public class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("Ivan");
        person.setAge(800);
        person.setAddress(new Address("Russia"));

        System.out.println(person);
        Person p2 = (Person) person.clone();
        System.out.println(p2);
        System.out.println("---------------------");
        person.getAddress().setCountry("New Country");
        System.out.println(person);
        System.out.println(p2);


        //p2.getAddress().setCountry("AAA");
/*
        System.out.println("-----------");
        person.setAge(900);
        person.setName("ASDFGHJ");
        System.out.println(p2);
        System.out.println(person);
        */
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = new Person();
        cloneActions(this, person);
        return person;
    }

    private void cloneActions(Person src, Person destionation) throws CloneNotSupportedException {
        destionation.name = src.name;
        destionation.age = src.age;
       // destionation.address = src.address.clone();

        Address copy = new Address(src.getAddress().getCountry());
        destionation.address = copy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
