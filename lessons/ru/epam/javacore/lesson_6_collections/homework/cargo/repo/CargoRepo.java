package ru.epam.javacore.lesson_6_collections.homework.cargo.repo;

import ru.epam.javacore.lesson_6_collections.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_6_collections.homework.common.business.repo.CommonRepo;

public interface CargoRepo extends CommonRepo {

  void add(Cargo cargo);

  Cargo getById(long id);

  Cargo[] getByName(String name);
}
