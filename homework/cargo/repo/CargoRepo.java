package ru.epam.javacore.lesson_24_db_web.homework.cargo.repo;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.repo.CommonRepo;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Optional<Cargo> getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);

  void save(Collection<Cargo> cargos);

  void save(Collection<Cargo> cargos, Connection connection);
}
