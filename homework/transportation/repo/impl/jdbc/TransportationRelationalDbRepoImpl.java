package ru.epam.javacore.lesson_24_db_web.homework.transportation.repo.impl.jdbc;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.impl.jdbc.CargoMapper;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.impl.jdbc.CarrierMapper;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.QueryWrapper;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.ResultSetExtractor;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.repo.TransportationRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class TransportationRelationalDbRepoImpl implements TransportationRepo {

  @Override
  public Optional<Transportation> findById(Long id) {
    String sql = "SELECT * FROM TRANSPORTATION WHERE ID = ?";
    return QueryWrapper.selectOne(sql,
        TransportationMapper::mapTransportation,
        ps -> {
          ps.setLong(1, id);
        });
  }

  @Override
  public void save(Transportation entity) {
    entity.setId(IdGenerator.generateId());
    String sql = "INSERT INTO TRANSPORTATION (ID, "
        + "CARGO_ID, "
        + "CARRIER_ID, "
        + "DESCRIPTION, "
        + "BILL_TO , "
        + "BEGIN_DATE) VALUES (?,?,?,?,?,?)";
    QueryWrapper.executeUpdate(sql, ps -> {
      int index = 0;
      ps.setLong(++index, entity.getId());
      ps.setLong(++index, entity.getCargo().getId());
      ps.setLong(++index, entity.getCarrier().getId());
      ps.setString(++index, entity.getDescription());
      ps.setString(++index, entity.getBillTo());
      ps.setTimestamp(++index, Timestamp.valueOf(entity.getTransportationBeginDate()));
    });
  }

  @Override
  public boolean update(Transportation entity) {
    return false;
  }

  @Override
  public boolean deleteById(Long id) {
    int affected = QueryWrapper.executeUpdate("DELETE FROM TRANSPORTATION WHERE ID = ?", ps -> {
      ps.setLong(1, id);
    });

    return affected > 0;
  }

  @Override
  public List<Transportation> getAll() {
    return QueryWrapper
        .select("SELECT * FROM TRANSPORTATION", TransportationMapper::mapTransportation);
  }

  @Override
  public List<Transportation> getAllFetchingCargoAndCarrier() {
    String sql = "SELECT tr.*, "
        + "crg.ID AS CARGO_ID,"
        + "crg.NAME AS CARGO_NAME,"
        + "crg.WEIGHT AS CARGO_WEIGHT,"
        + "crg.ENTITY_TYPE AS CARGO_ENTITY_TYPE,"
        + "crg.CLOTHERS_SIZE AS CARGO_CLOTHERS_SIZE,"
        + "crg.CLOTHERS_MATERIAL AS CARGO_CLOTHERS_MATERIAL,"
        + "crg.FOOD_EXPIRATION_DATE AS CARGO_FOOD_EXPIRATION_DATE,"
        + "crg.FOOD_STORE_TEMPERATURE AS CARGO_FOOD_STORE_TEMPERATURE,"
        + "cr.ID AS CARRIER_ID,"
        + "cr.NAME AS CARRIER_NAME,"
        + "cr.ADDRESS AS CARRIER_ADDRESS,"
        + "cr.ENTITY_TYPE AS CARRIER_ENTITY_TYPE"
        + " FROM TRANSPORTATION tr "
        + "INNER JOIN CARGO crg ON (tr.CARGO_ID = crg.ID) "
        + "INNER JOIN CARRIER cr ON (tr.CARRIER_ID = cr.ID)";

    return QueryWrapper.select(sql, rs -> {
      Transportation tr = TransportationMapper.mapTransportation(rs);

      Carrier carrier = CarrierMapper.mapCarrier(rs, "CARRIER_");
      Cargo cargo = CargoMapper.mapCargo(rs, "CARGO_");

      tr.setCargo(cargo);
      tr.setCarrier(carrier);
      return tr;
    });
  }

  @Override
  public int countAll() {
    return QueryWrapper.selectOne("SELECT COUNT(*) AS CNT FROM TRANSPORTATION",
        (rs) -> rs.getInt("CNT")).orElse(0);
  }
}
