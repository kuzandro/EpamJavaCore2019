package ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.impl;


import static ru.epam.javacore.lesson_24_db_web.homework.storage.Storage.cargoCollection;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.CollectionUtils;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;

import java.sql.Connection;
import java.util.*;

public class CargoCollectionRepoImpl extends CommonCargoRepo {

  @Override
  public Optional<Cargo> getByIdFetchingTransportations(long id) {
    return findById(id);
  }

  @Override
  public Cargo[] findByName(String name) {
    List<Cargo> result = new ArrayList<>();

    for (Cargo carrier : cargoCollection) {
      if (Objects.equals(carrier.getName(), name)) {
        result.add(carrier);
      }
    }

    return result.toArray(new Cargo[0]);
  }

  @Override
  public List<Cargo> search(CargoSearchCondition searchCondition) {
    List<Cargo> cargos = getAll();

    if (CollectionUtils.isNotEmpty(cargos)) {
      if (searchCondition.needSorting()) {
        Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
        cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
      }
    }

    return cargos;
  }

  @Override
  public Optional<Cargo> findById(Long id) {
    for (Cargo carrier : cargoCollection) {
      if (id != null && id.equals(carrier.getId())) {
        return Optional.of(carrier);
      }
    }

    return Optional.empty();
  }

  @Override
  public void save(Cargo cargo) {
    cargo.setId(IdGenerator.generateId());
    cargoCollection.add(cargo);
  }

  @Override
  public void save(Collection<Cargo> cargos) {
    cargos.forEach(this::save);
  }

  @Override
  public void save(Collection<Cargo> cargos, Connection connection) {
    this.save(cargos);
  }

  @Override
  public boolean update(Cargo entity) {
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
    Iterator<Cargo> iter = cargoCollection.iterator();

    boolean removed = false;
    while (iter.hasNext()) {
      if (id != null && id.equals(iter.next().getId())) {
        iter.remove();
        removed = true;
        break;
      }
    }

    return removed;
  }

  @Override
  public List<Cargo> getAll() {
    return cargoCollection;
  }

  @Override
  public int countAll() {
    return cargoCollection.size();
  }


}
