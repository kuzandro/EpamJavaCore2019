package ru.epam.javacore.lesson_9_exceptions.homework.transportation.service;

import ru.epam.javacore.lesson_9_exceptions.homework.common.business.service.CommonService;
import ru.epam.javacore.lesson_9_exceptions.homework.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
  void add(Transportation transportation);

  Transportation getById(Long id);

  List<Transportation> getAll();

  void update(Transportation transportation);

}
