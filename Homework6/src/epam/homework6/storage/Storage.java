package epam.homework6.storage;


import epam.homework6.cargo.domain.Cargo;
import epam.homework6.carrier.domain.Carrier;
import epam.homework6.common.utils.ArrayUtils;
import epam.homework6.transportation.domain.Transportation;

import java.util.Objects;

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

    if (cargoIndex == cargos.length) {
      Cargo[] newCargos = new Cargo[cargos.length * 2];
      ArrayUtils.copyArray(cargos, newCargos);
      cargos = newCargos;
    }
  }

  public static void deleteCargoById(long id) {
    Cargo[] newCargos = new Cargo[cargos.length];
    int i = 0;
    for (Cargo cargo : cargos) {
      if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
        i++;
      } else {
        newCargos[i] = cargo;
        i++;
      }
    }
    cargos = newCargos;
    cargoIndex = cargoIndex - 1;
  }

  public static Cargo getCargoById(long id) {
    for (Cargo cargo : cargos) {
      if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
        return cargo;
      }
    }

    return null;
  }

  public static Cargo[] getCargosByName(String name) {
    Cargo[] result = new Cargo[cargos.length];

    int curIndex = 0;
    for (Cargo cargo : cargos) {
      if (cargo != null && Objects.equals(cargo.getName(), name)) {
        result[curIndex++] = cargo;
      }
    }

    return result;
  }

  public static void printAllCargos() {
    ArrayUtils.printArray(cargos);
  }

  public static void addCarrier(Carrier carrier) {
    carrier.setId(IdGenerator.generateId());
    carriers[carrierIndex] = carrier;
    carrierIndex++;

    if (carrierIndex == carriers.length) {
      Carrier[] newCarriers = new Carrier[carriers.length * 2];
      ArrayUtils.copyArray(carriers, newCarriers);
      carriers = newCarriers;
    }
  }

  public static void deleteCarrierById(long id) {
    Carrier[] newCarriers = new Carrier[carriers.length];
    int i = 0;
    for (Carrier carrier : carriers) {
      if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
        i++;
      } else {
        newCarriers[i] = carrier;
        i++;
      }
    }
    carriers = newCarriers;
    carrierIndex = carrierIndex - 1;
  }

  public static Carrier getCarrierById(long id) {
    for (Carrier carrier : carriers) {
      if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
        return carrier;
      }
    }

    return null;
  }

  public static Carrier[] getCarriersByName(String name) {
    Carrier[] result = new Carrier[carriers.length];

    int curIndex = 0;
    for (Carrier carrier : carriers) {
      if (carrier != null && Objects.equals(carrier.getName(), name)) {
        result[curIndex++] = carrier;
      }
    }

    return result;
  }

  public static void printAllCarriers() {
    ArrayUtils.printArray(carriers);
  }

  public static void addTransportation(Transportation transportation) {
    transportation.setId(IdGenerator.generateId());
    transportations[transportationIndex] = transportation;
    transportationIndex++;

    if (transportationIndex == transportations.length) {
      Transportation[] newTransportations = new Transportation[transportations.length * 2];
      ArrayUtils.copyArray(transportations, newTransportations);
      transportations = newTransportations;
    }
  }

  public static void deleteTransportationById(long id) {
    Transportation[] newTransportations = new Transportation[transportations.length];
    int i = 0;
    for (Transportation transportation : transportations) {
      if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
        i++;
      } else {
        newTransportations[i] = transportation;
        i++;
      }
    }
    transportations = newTransportations;
    transportationIndex = transportationIndex - 1;
  }

  public static Transportation getTransportationById(long id) {
    for (Transportation transportation : transportations) {
      if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
        return transportation;
      }
    }

    return null;
  }

  public static void printAllTransportations() {
    ArrayUtils.printArray(transportations);
  }

}
