package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.service;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
  void add(Carrier carrier);

  Carrier getById(Long id);

  List<Carrier> findByName(String name);

  List<Carrier> getAll();

  void update(Carrier carrier);

}
