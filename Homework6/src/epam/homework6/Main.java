package epam.homework6;

import epam.homework6.cargo.domain.Cargo;
import epam.homework6.cargo.domain.FoodCargo;
import epam.homework6.cargo.repo.CargoCrudRepo;
import epam.homework6.carrier.repo.CarrierCrudRepo;
import epam.homework6.storage.Storage;
import epam.homework6.carrier.domain.Carrier;
import epam.homework6.transportation.repo.TransportationCrudRepo;
import epam.homework6.transportation.domain.Transportation;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        CargoCrudRepo cargoCrudRepo = new CargoCrudRepo();
        Cargo apples = new FoodCargo();
        apples.setName("apples");
        cargoCrudRepo.add(apples, storage);
        Cargo oranges = new FoodCargo();
        oranges.setName("oranges");
        cargoCrudRepo.add(oranges, storage);
        Cargo cucumbers = new FoodCargo();
        cucumbers.setName("cucumbers");
        cargoCrudRepo.add(cucumbers, storage);
        Cargo kiwis = new FoodCargo();
        kiwis.setName("kiwis");
        cargoCrudRepo.add(kiwis, storage);
        System.out.println("All cargos in storage:");
        storage.printAllCargos();

        System.out.println("\nGet cucumbers id = 3");

        Cargo getCucumbers = cargoCrudRepo.get(3L, storage);
        System.out.println(getCucumbers.toString());

        System.out.println("\nDelete oranges id = 2");
        cargoCrudRepo.delete(2L, storage);
        storage.printAllCargos();

        CarrierCrudRepo carrierCrudRepo = new CarrierCrudRepo();
        Carrier ship = new Carrier();
        ship.setName("ship");
        carrierCrudRepo.add(ship, storage);
        Carrier plane = new Carrier();
        plane.setName("plane");
        carrierCrudRepo.add(plane, storage);
        Carrier car = new Carrier();
        car.setName("car");
        carrierCrudRepo.add(car, storage);
        System.out.println("\nAll carriers in storage:");
        storage.printAllCarriers();

        System.out.println("\nGet ship id = 5");

        Carrier getShip = carrierCrudRepo.get(5L, storage);
        System.out.println(getShip.toString());

        System.out.println("\nDelete car id = 7");
        carrierCrudRepo.delete(7L, storage);
        storage.printAllCarriers();

        TransportationCrudRepo transportationCrudRepo = new TransportationCrudRepo();

        Transportation transportation1 = new Transportation();
        transportation1.setBillTo("Apple Ship Man");
        transportation1.setCargo(apples);
        transportation1.setCarrier(ship);
        transportationCrudRepo.add(transportation1, storage);
        Transportation transportation2 = new Transportation();
        transportation2.setBillTo("Oranges Plane Man");
        transportation2.setCargo(oranges);
        transportation2.setCarrier(plane);
        transportationCrudRepo.add(transportation2, storage);
        Transportation transportation3 = new Transportation();
        transportation3.setBillTo("Cucumbers Car Man");
        transportation3.setCargo(cucumbers);
        transportation3.setCarrier(car);
        transportationCrudRepo.add(transportation3, storage);
        System.out.println("\nAll transportations in storage:");
        storage.printAllTransportations();

        System.out.println("\nGet transportation id = 9");

        Transportation getT9 = transportationCrudRepo.get(9L, storage);
        System.out.println(getT9.toString());

        System.out.println("\nDelete transportation id = 10");
        transportationCrudRepo.delete(10L, storage);
        storage.printAllTransportations();
    }
}
