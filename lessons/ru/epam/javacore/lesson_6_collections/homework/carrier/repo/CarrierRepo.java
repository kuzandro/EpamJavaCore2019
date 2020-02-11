package ru.epam.javacore.lesson_6_collections.homework.carrier.repo;

import ru.epam.javacore.lesson_6_collections.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_6_collections.homework.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo {

  void add(Carrier carrier);

  Carrier getById(long id);

  Carrier[] getByName(String name);

}
