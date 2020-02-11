package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects.a_2_improvement_of_house;

public class House {

    private int price;
    private int floorNumber;
    private Address address;
    private Owner owner;

    public House(int price,
                 int floorNumber,
                 Address address,
                 Owner owner) {
        this.price = price;
        this.floorNumber = floorNumber;
        this.address = address;
        this.owner = owner;
    }

    public House() {
    }

    public static void main(String[] args) {

        House house = new House(
                33,
                2,
                new Address("Prosvesheniya", 22),
                new Owner("Ivan", "Ivanov")
        );

        house = new House();

        Address address = house.getAddress();
        if (address != null) {
            System.out.println(address.getHouse());
            System.out.println(address.getStreet());
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
