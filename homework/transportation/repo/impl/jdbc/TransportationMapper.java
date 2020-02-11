package ru.epam.javacore.lesson_24_db_web.homework.transportation.repo.impl.jdbc;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.ProxyCargo;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.ProxyCarrier;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.exception.unchecked.SqlException;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;

import java.sql.ResultSet;
import java.time.LocalDateTime;

final public class TransportationMapper {

  private TransportationMapper() {

  }

  public static Transportation mapTransportation(ResultSet rs) {
    try {
      Transportation transportation = new Transportation();
      transportation.setId(rs.getLong("ID"));
      ProxyCargo cargo = new ProxyCargo(rs.getLong("CARGO_ID"));
      transportation.setCargo(cargo);
      transportation.setCarrier(new ProxyCarrier(rs.getLong("CARRIER_ID")));
      transportation.setDescription(rs.getString("DESCRIPTION"));
      transportation.setBillTo(rs.getString("BILL_TO"));
      transportation.setTransportationBeginDate(
          LocalDateTime.from(rs.getTimestamp("BEGIN_DATE").toLocalDateTime()));
      return transportation;
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }
}
