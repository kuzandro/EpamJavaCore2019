package ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.impl.jdbc;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.CargoType;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.ClothersCargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.FoodCargo;

import java.sql.ResultSet;

public final class CargoMapper {

  public static Cargo mapCargo(ResultSet rs) {
    return mapCargo(rs, "");
  }

  public static Cargo mapCargo(ResultSet rs, String aliasPrefix) {
    try {
      CargoType cargoType = CargoType.valueOf(rs.getString(aliasPrefix + "ENTITY_TYPE"));
      if (CargoType.CLOTHERS.equals(cargoType)) {
        return mapClothersCargo(rs, aliasPrefix);
      } else {
        return mapFoodCargo(rs, aliasPrefix);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  private static FoodCargo mapFoodCargo(ResultSet rs, String aliasPrefix) throws Exception {
    FoodCargo foodCargo = new FoodCargo();
    mapCommonFields(foodCargo, rs, aliasPrefix);
    foodCargo
        .setExpirationDate(rs.getTimestamp(aliasPrefix + "FOOD_EXPIRATION_DATE").toLocalDateTime());
    foodCargo.setStoreTemperature(rs.getInt(aliasPrefix + "FOOD_STORE_TEMPERATURE"));
    return foodCargo;
  }

  private static ClothersCargo mapClothersCargo(ResultSet rs, String aliasPrefix) throws Exception {
    ClothersCargo clothersCargo = new ClothersCargo();
    mapCommonFields(clothersCargo, rs, aliasPrefix);
    clothersCargo.setMaterial(rs.getString(aliasPrefix + "CLOTHERS_SIZE"));
    clothersCargo.setSize(rs.getString(aliasPrefix + "CLOTHERS_MATERIAL"));
    return clothersCargo;
  }

  private static void mapCommonFields(Cargo cargo, ResultSet rs, String aliasPrefix)
      throws Exception {
    cargo.setId(rs.getLong(aliasPrefix + "ID"));
    cargo.setName(rs.getString(aliasPrefix + "NAME"));
    cargo.setWeight(rs.getInt(aliasPrefix + "WEIGHT"));
  }
}
