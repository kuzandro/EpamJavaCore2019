package epam.homework5;

import epam.homework5.cargo.domain.Cargo;
import epam.homework5.carrier.domain.Carrier;
import epam.homework5.transportation.domain.Transportation;

public class Storage {
    private static final int ARRAY_CAPACITY = 10;

    private static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    private static int cargoIndex = 0;
    private static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    private static int carrierIndex = 0;
    private static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    private static int transportationIndex = 0;

    public static void addCargo(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Cargo[] newCargos = new Cargo[cargoIndex + ARRAY_CAPACITY];
            copyCargoArray(cargos, newCargos);
            cargos = newCargos;
        }
    }

    public static void addCarrier(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (carrierIndex % (ARRAY_CAPACITY - 1) == 0) {
            Carrier[] newCarriers = new Carrier[carrierIndex + ARRAY_CAPACITY];
            copyCarriersArray(carriers, newCarriers);
            carriers = newCarriers;
        }
    }

    public static void addTransportation(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (transportationIndex % (ARRAY_CAPACITY - 1) == 0) {
            Transportation[] newTransportations = new Transportation[transportationIndex + ARRAY_CAPACITY];
            copyTransportationsArray(transportations, newTransportations);
            transportations = newTransportations;
        }
    }

    private static void copyCargoArray(Cargo[] src, Cargo[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    private static void copyCarriersArray(Carrier[] src, Carrier[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    private static void copyTransportationsArray(Transportation[] src, Transportation[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    public static void printAllCargos() {
        for (Cargo cargo: cargos){
            if (cargo != null) {
                System.out.println(cargo);
            }
        }
    }

    public static Cargo[] getAllCargos() {
        return cargos;
    }

    public static void printAllCarriers() {
        for (Carrier carrier: carriers){
            if (carrier != null) {
                System.out.println(carrier);
            }
        }
    }

    public static Carrier[] getAllCarriers() {
        return carriers;
    }

    public static void printAllTransportations() {
        for (Transportation transportation: transportations){
            if (transportation != null) {
                System.out.println(transportation);
            }
        }
    }

    public static Transportation[] getAllTransportations() {
        return transportations;
    }

    public static Cargo getCargoByName(String name) {
        Cargo neededCargo = new Cargo();
        boolean hasTheCargo = false;
        for (Cargo cargo: cargos){
            if (cargo != null && cargo.getName().equals(name)) {
                neededCargo = cargo;
                hasTheCargo = true;
                break;
            }
        }
        if (hasTheCargo) {
            return neededCargo;
        } else {
            return new Cargo();
        }
    }

    public static Cargo getCargoById(Long id) {
        Cargo neededCargo = new Cargo();
        boolean hasTheCargo = false;
        for (Cargo cargo: cargos){
            if (cargo != null && cargo.getId().equals(id)) {
                neededCargo = cargo;
                hasTheCargo = true;
                break;
            }
        }
        if (hasTheCargo) {
            return neededCargo;
        } else {
            return new Cargo();
        }
    }

    public static Carrier getCarrierByName(String name) {
        Carrier neededCarrier = new Carrier();
        boolean hasTheCarrier = false;
        for (Carrier carrier: carriers){
            if (carrier != null && carrier.getName().equals(name)) {
                neededCarrier = carrier;
                hasTheCarrier = true;
                break;
            }
        }
        if (hasTheCarrier) {
            return neededCarrier;
        } else {
            return new Carrier();
        }
    }

    public static Carrier getCarrierById(Long id) {
        Carrier neededCarrier = new Carrier();
        boolean hasTheCarrier = false;
        for (Carrier carrier: carriers){
            if (carrier != null && carrier.getId().equals(id)) {
                neededCarrier = carrier;
                hasTheCarrier = true;
                break;
            }
        }
        if (hasTheCarrier) {
            return neededCarrier;
        } else {
            return new Carrier();
        }
    }

    public static Transportation getTransportationById(Long id) {
        Transportation neededTransportation = new Transportation();
        boolean hasTheTransportation = false;
        for (Transportation transportation: transportations){
            if (transportation != null && transportation.getId().equals(id)) {
                neededTransportation = transportation;
                hasTheTransportation = true;
                break;
            }
        }
        if (hasTheTransportation) {
            return neededTransportation;
        } else {
            return new Transportation();
        }
    }
}
