package ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.impl;


import static ru.epam.javacore.lesson_24_db_web.homework.storage.Storage.carrierCollection;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.CarrierRepo;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;

import java.sql.Connection;
import java.util.*;

public class CarrierCollectionRepoImpl implements CarrierRepo {

  @Override
  public void save(Carrier carrier) {
    carrier.setId(IdGenerator.generateId());
    carrierCollection.add(carrier);
  }

  @Override
  public void save(Collection<Carrier> carriers) {
    carriers.forEach(this::save);
  }

  @Override
  public void save(Collection<Carrier> carriers, Connection connection) {
    this.save(carriers);
  }

  @Override
  public Optional<Carrier> findById(Long id) {
    for (Carrier carrier : carrierCollection) {
      if (carrier.getId().equals(id)) {
        return Optional.of(carrier);
      }
    }

    return Optional.empty();
  }

  @Override
  public Optional<Carrier> getByIdFetchingTransportations(long id) {
    return findById(id);
  }

  @Override
  public Carrier[] findByName(String name) {
    List<Carrier> result = new ArrayList<>();

    for (Carrier carrier : carrierCollection) {
      if (Objects.equals(carrier.getName(), name)) {
        result.add(carrier);
      }
    }

    return result.toArray(new Carrier[0]);
  }

  @Override
  public boolean deleteById(Long id) {
    Iterator<Carrier> iter = carrierCollection.iterator();

    boolean removed = false;
    while (iter.hasNext()) {
      if (iter.next().getId().equals(id)) {
        iter.remove();
        removed = true;
        break;
      }
    }

    return removed;
  }

  @Override
  public List<Carrier> getAll() {
    return carrierCollection;
  }

  @Override
  public int countAll() {
    return carrierCollection.size();
  }

  @Override
  public boolean update(Carrier carrier) {
    return true;
  }

}
