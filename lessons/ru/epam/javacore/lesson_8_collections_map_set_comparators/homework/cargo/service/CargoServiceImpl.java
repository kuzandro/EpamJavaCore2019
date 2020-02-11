package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.service;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.repo.CargoRepo;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.search.CargoSearchCondition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CargoServiceImpl implements CargoService {

  private CargoRepo cargoRepo;

  public CargoServiceImpl(CargoRepo cargoRepo) {
    this.cargoRepo = cargoRepo;
  }

  @Override
  public void add(Cargo cargo) {
    cargoRepo.add(cargo);
  }

  @Override
  public Cargo getById(Long id) {
    if (id != null) {
      return cargoRepo.getById(id);
    }
    return null;
  }

  @Override
  public List<Cargo> getAll() {
    return cargoRepo.getAll();
  }

  @Override
  public List<Cargo> findByName(String name) {
    Cargo[] found = cargoRepo.findByName(name);
    return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
  }

  @Override
  public boolean deleteById(Long id) {
    return cargoRepo.deleteById(id);
  }

  @Override
  public void printAll() {
    List<Cargo> allCargos = cargoRepo.getAll();

    for (Cargo cargo : allCargos) {
      System.out.println(cargo);
    }
  }

  @Override
  public void update(Cargo cargo) {
    if (cargo != null) {
      cargoRepo.update(cargo);
    }
  }

  @Override
  public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
    return cargoRepo.search(cargoSearchCondition);
  }
}
