package ru.epam.javacore.lesson_24_db_web.homework.carrier.repo;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.repo.CommonRepo;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Optional<Carrier> getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

  void save(Collection<Carrier> carriers);

  void save(Collection<Carrier> carriers, Connection connection);

}
