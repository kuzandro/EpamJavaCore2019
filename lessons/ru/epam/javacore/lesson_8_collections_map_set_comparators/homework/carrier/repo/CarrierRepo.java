package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.repo;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo {

  void add(Carrier carrier);

  Carrier getById(long id);

  Carrier[] findByName(String name);

  List<Carrier> getAll();

  void update(Carrier carrier);
}
