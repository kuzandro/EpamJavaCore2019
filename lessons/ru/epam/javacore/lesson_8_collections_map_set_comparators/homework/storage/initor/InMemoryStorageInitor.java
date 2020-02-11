package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.storage.initor;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.application.serviceholder.ServiceHolder;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.domain.ClothersCargo;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.domain.FoodCargo;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.service.CargoService;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.service.CarrierService;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.transportation.domain.Transportation;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.transportation.service.TransportationService;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class InMemoryStorageInitor implements StorageInitor {

  private static final int TOTAL_ENTITIES_IN_GROUP = 6;

  private final CarrierService carrierService;
  private final CargoService cargoService;
  private final TransportationService transportationService;

  public InMemoryStorageInitor() {
    carrierService = ServiceHolder.getInstance().getCarrierService();
    cargoService = ServiceHolder.getInstance().getCargoService();
    transportationService = ServiceHolder.getInstance().getTransportationService();
  }

  @Override
  public void initStorage() {
    initCargos();
    initCarriers();
    initTransportations();
  }

  private void initCargos() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      cargoService.add(createClothersCargo(i));
    }
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      cargoService.add(createFoodCargo(i));
    }
  }

  private ClothersCargo createClothersCargo(int index) {
    ClothersCargo cargo = new ClothersCargo();
    cargo.setSize("Clothers_Size_" + index);
    cargo.setName("Jeans");
    cargo.setWeight(ThreadLocalRandom.current().nextInt(1, 100 + 1));

    return cargo;
  }

  private FoodCargo createFoodCargo(int index) {
    FoodCargo cargo = new FoodCargo();
    cargo.setExpirationDate(new Date());
    cargo.setStoreTemperature(index);
    cargo.setWeight(ThreadLocalRandom.current().nextInt(1, 100 + 1));
    cargo.setName("Milk");

    return cargo;
  }

  private void initCarriers() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Carrier carrier = createCarrier(i);
      carrierService.add(carrier);
    }
  }

  private Carrier createCarrier(int index) {
    Carrier carrier = new Carrier();
    carrier.setName("Carrier_Name");
    carrier.setAddress("Address_" + index);
    return carrier;
  }

  private void initTransportations() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Transportation transportation = createTransportation(i + 1, i + 1 + TOTAL_ENTITIES_IN_GROUP);
      transportationService.add(transportation);
    }
  }

  private Transportation createTransportation(long cargoId, long carrierId) {
    Transportation transportation = new Transportation();
    transportation.setCargo(cargoService.getById(cargoId));
    transportation.setCarrier(carrierService.getById(carrierId));
    transportation.setDescription("Transportation");

    return transportation;
  }

}
