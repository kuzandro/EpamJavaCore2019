package epam.homework5;

import epam.homework5.cargo.domain.Cargo;
import epam.homework5.cargo.domain.Computer;
import epam.homework5.cargo.domain.Phone;
import epam.homework5.carrier.domain.Carrier;
import epam.homework5.transportation.domain.Transportation;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Cargo apples = new Cargo();
        apples.setName("apples");
        storage.addCargo(apples);
        Cargo oranges = new Cargo();
        oranges.setName("oranges");
        storage.addCargo(oranges);
        Cargo cucumbers = new Cargo();
        cucumbers.setName("cucumbers");
        storage.addCargo(cucumbers);
        System.out.println("All cargos in storage:");
        storage.printAllCargos();
        System.out.println("\n");

        Carrier ship = new Carrier();
        ship.setName("ship");
        storage.addCarrier(ship);
        Carrier plane = new Carrier();
        plane.setName("plane");
        storage.addCarrier(plane);
        Carrier car = new Carrier();
        car.setName("car");
        storage.addCarrier(car);
        System.out.println("All carriers in storage:");
        storage.printAllCarriers();
        System.out.println("\n");

        Transportation transportation1 = new Transportation();
        transportation1.setBillTo("Apple Ship Man");
        transportation1.setCargo(apples);
        transportation1.setCarrier(ship);
        storage.addTransportation(transportation1);
        Transportation transportation2 = new Transportation();
        transportation2.setBillTo("Oranges Plane Man");
        transportation2.setCargo(oranges);
        transportation2.setCarrier(plane);
        storage.addTransportation(transportation2);
        Transportation transportation3 = new Transportation();
        transportation3.setBillTo("Cucumbers Car Man");
        transportation3.setCargo(cucumbers);
        transportation3.setCarrier(car);
        storage.addTransportation(transportation3);
        System.out.println("All transportations in storage:");
        storage.printAllTransportations();
        System.out.println("\n");

        System.out.println("Get crago by name oranges:");
        Cargo getTheCargo = storage.getCargoByName("oranges");
        System.out.println(getTheCargo.toString());
        System.out.println("Get cargo by name ppp (no such name):");
        Cargo getTheCargo2 = storage.getCargoByName("ppp");
        System.out.println(getTheCargo2.toString());
        System.out.println("Get crago by id 3:");
        Cargo getTheCargo3 = storage.getCargoById(3L);
        System.out.println(getTheCargo3.toString());
        System.out.println("Get cargo by id 33 (no such id):");
        Cargo getTheCargo4 = storage.getCargoById(33L);
        System.out.println(getTheCargo4.toString());

        System.out.println("\nGet carrier by name plane:");
        Carrier getTheCarrier = storage.getCarrierByName("plane");
        System.out.println(getTheCarrier.toString());
        System.out.println("Get carrier by name nnn (no such name):");
        Carrier getTheCarrier2 = storage.getCarrierByName("nnn");
        System.out.println(getTheCarrier2.toString());
        System.out.println("Get crago by id 4:");
        Carrier getTheCarrier3 = storage.getCarrierById(4L);
        System.out.println(getTheCarrier3.toString());
        System.out.println("Get cargo by id 55 (no such id):");
        Carrier getTheCarrier4 = storage.getCarrierById(55L);
        System.out.println(getTheCarrier4.toString());

        System.out.println("\nGet transportation by id 9:");
        Transportation getTheTransportation = storage.getTransportationById(9L);
        System.out.println(getTheTransportation.toString());
        System.out.println("Get cargo by id 99 (no such id):");
        Transportation getTheTransportation2 = storage.getTransportationById(99L);
        System.out.println(getTheTransportation2.toString());

        System.out.println("\nGet all cargos and print:");
        Cargo[] allCargos = storage.getAllCargos();
        for (Cargo cargo: allCargos){
            if (cargo != null) {
                System.out.println(cargo);
            }
        }

        System.out.println("\nGet all carriers and print:");
        Carrier[] allCarriers = storage.getAllCarriers();
        for (Carrier carrier: allCarriers){
            if (carrier != null) {
                System.out.println(carrier);
            }
        }

        System.out.println("\nGet all transportations and print:");
        Transportation[] allTransportations = storage.getAllTransportations();
        for (Transportation transportation: allTransportations){
            if (transportation != null) {
                System.out.println(transportation);
            }
        }

        Phone iPhone = new Phone();
        iPhone.setName("iPhone");
        iPhone.setId(IdGenerator.generateId());
        iPhone.setProducer("Apple");
        System.out.println("\n" + iPhone.toString());

        Computer MacBook = new Computer();
        MacBook.setName("MacBook");
        MacBook.setId(IdGenerator.generateId());
        MacBook.setProducer("Apple");
        MacBook.setSSD(256);
        System.out.println("\n" + MacBook.toString());

    }
}
