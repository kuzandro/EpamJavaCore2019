package ru.epam.javacore.lesson_2_oop.lesson.a_1_creation_objects;

public class House {

    private int price;
    private String street;
    private int houseNumber;
    private int floorNumber;
    private String ownerName;
    private String ownerLastName;

    public House(String street, int house) {
        this.street = street;
        this.houseNumber = house;

    }

    public House(int price,
                 String street,
                 int houseNumber,
                 int floorNumber,
                 String ownerName,
                 String ownerLastName) {
        this.price = price;
        this.street = street;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.ownerName = ownerName;
        this.ownerLastName = ownerLastName;
    }

    public House() {

    }

    public static void main(String[] args) {
        int l = 99;
        System.out.println("jgjg");
        House house = new House();
        house.setFloorNumber(1);
        house.setPrice(3);
        System.out.println(house);

        house = new House("Nevskiy prospectus", 333);
        System.out.println(house);

        house = new House(11, "Ispytateley",
                          33,
                          66,
                          "Abramovich",
                          "Arcadiy");
        System.out.println(house);
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", floorNumber=" + floorNumber +
                ", ownerName='" + ownerName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }
}
