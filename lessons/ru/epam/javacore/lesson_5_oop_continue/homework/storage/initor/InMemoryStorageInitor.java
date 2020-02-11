package ru.epam.javacore.lesson_5_oop_continue.homework.storage.initor;

import ru.epam.javacore.lesson_5_oop_continue.homework.cargo.domain.ClothersCargo;
import ru.epam.javacore.lesson_5_oop_continue.homework.cargo.domain.FoodCargo;
import ru.epam.javacore.lesson_5_oop_continue.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_5_oop_continue.homework.storage.Storage;
import ru.epam.javacore.lesson_5_oop_continue.homework.transportation.domain.Transportation;

import java.util.Date;

public class InMemoryStorageInitor implements StorageInitor {

  private static final int TOTAL_ENTITIES_IN_GROUP = 6;

  @Override
  public void initStorage() {
    initCargos();
    initCarriers();
    initTransportations();
  }

  private void initTransportations() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Transportation transportation = createTransportation(i + 1, i + 1 + TOTAL_ENTITIES_IN_GROUP);
      Storage.addTransportation(transportation);
    }
  }

  private Transportation createTransportation(long cargoId, long carrierId) {
    Transportation transportation = new Transportation();
    transportation.setCargo(Storage.getCargoById(cargoId));
    transportation.setCarrier(Storage.getCarrierById(carrierId));
    transportation.setDescription("Transportation");

    return transportation;
  }

  private void initCarriers() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Carrier carrier = createCarrier(i);
      Storage.addCarrier(carrier);
    }
  }

  private Carrier createCarrier(int index) {
    Carrier carrier = new Carrier();
    carrier.setName("Carrier_Name");
    carrier.setAddress("Address_" + index);
    return carrier;
  }

  private void initCargos() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      Storage.addCargo(createClothersCargo(i));
    }
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      Storage.addCargo(createFoodCargo(i));
    }
  }

  private ClothersCargo createClothersCargo(int index) {
    ClothersCargo cargo = new ClothersCargo();
    cargo.setSize("Clothers_Size_" + index);
    cargo.setName("Clothers_Name_" + index);

    return cargo;
  }

  private FoodCargo createFoodCargo(int index) {
    FoodCargo cargo = new FoodCargo();
    cargo.setExpirationDate(new Date());
    cargo.setStoreTemperature(index);
    cargo.setName("FoodCargo_Name_" + index);

    return cargo;
  }

}