package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.service;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.repo.CarrierRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarrierServiceImpl implements CarrierService {

  private CarrierRepo carrierRepo;

  public CarrierServiceImpl(
      CarrierRepo carrierRepo) {
    this.carrierRepo = carrierRepo;
  }

  @Override
  public void add(Carrier carrier) {
    carrierRepo.add(carrier);
  }

  @Override
  public Carrier getById(Long id) {
    if (id != null) {
      return carrierRepo.getById(id);
    }
    return null;
  }

  @Override
  public List<Carrier> findByName(String name) {
    Carrier[] found = carrierRepo.findByName(name);
    return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);

  }

  @Override
  public List<Carrier> getAll() {
    return carrierRepo.getAll();
  }

  @Override
  public boolean deleteById(Long id) {
    return carrierRepo.deleteById(id);
  }

  @Override
  public void printAll() {
    List<Carrier> carriers = carrierRepo.getAll();
    for (Carrier carrier : carriers) {
      System.out.println(carrier);
    }
  }

  @Override
  public void update(Carrier carrier) {
    if (carrier != null) {
      carrierRepo.update(carrier);
    }
  }
}
