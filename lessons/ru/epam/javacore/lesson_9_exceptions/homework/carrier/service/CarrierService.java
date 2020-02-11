package ru.epam.javacore.lesson_9_exceptions.homework.carrier.service;

import ru.epam.javacore.lesson_9_exceptions.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_9_exceptions.homework.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
  void add(Carrier carrier);

  Carrier getById(Long id);

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

  List<Carrier> getAll();

  void update(Carrier carrier);

}
