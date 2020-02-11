package ru.epam.javacore.lesson_9_exceptions.homework.cargo.repo;

import ru.epam.javacore.lesson_9_exceptions.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_9_exceptions.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_9_exceptions.homework.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

  void add(Cargo cargo);

  Cargo getById(long id);

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> getAll();

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);

  void update(Cargo cargo);
}
