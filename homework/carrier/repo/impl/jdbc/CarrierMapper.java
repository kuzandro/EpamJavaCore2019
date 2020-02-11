package ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.impl.jdbc;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.CarrierType;

import java.sql.ResultSet;

public final class CarrierMapper {

  private CarrierMapper() {

  }

  public static Carrier mapCarrier(ResultSet rs) {
    try {
      Carrier carrier = new Carrier();
      carrier.setId(rs.getLong("ID"));
      carrier.setName(rs.getString("NAME"));
      carrier.setAddress(rs.getString("ADDRESS"));
      carrier.setCarrierType(CarrierType.valueOf(rs.getString("ENTITY_TYPE")));

      return carrier;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Carrier mapCarrier(ResultSet rs, String aliasPrefix) {
    try {
      Carrier carrier = new Carrier();
      carrier.setId(rs.getLong(aliasPrefix + "ID"));
      carrier.setName(rs.getString(aliasPrefix + "NAME"));
      carrier.setAddress(rs.getString(aliasPrefix + "ADDRESS"));
      carrier.setCarrierType(CarrierType.valueOf(rs.getString(aliasPrefix + "ENTITY_TYPE")));

      return carrier;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
