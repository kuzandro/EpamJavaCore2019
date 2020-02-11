package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.transportation.service;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.service.CommonService;
import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
  void add(Transportation transportation);

  Transportation getById(Long id);

  List<Transportation> getAll();

  void update(Transportation transportation);

}
