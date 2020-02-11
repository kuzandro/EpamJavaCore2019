package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.repo;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

  void add(Cargo cargo);

  Cargo getById(long id);

  Cargo[] findByName(String name);

  List<Cargo> getAll();

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);

  void update(Cargo cargo);
}
