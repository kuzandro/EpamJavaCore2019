package epam.homework4;

import epam.homework4.cargo.Cargo;
import epam.homework4.storage.Storage;

public class Main {

    public static void main(String[] args) {
        Cargo apples = new Cargo();
        apples.setName("apples");
        Cargo oranges = new Cargo();
        oranges.setName("oranges");
        Cargo cucumbers = new Cargo();
        cucumbers.setName("cucumbers");

        Storage storage = new Storage();

        storage.printCargos();

        storage.addCargo(apples);
        System.out.println("\n");
        storage.addCargo(oranges);
        System.out.println("\n");
        storage.addCargo(cucumbers);


    }
}
