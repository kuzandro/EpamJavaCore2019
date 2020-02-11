package ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.impl.jdbc;


import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.CargoType;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.ClothersCargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.FoodCargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.impl.CommonCargoRepo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.QueryWrapper;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.ResultSetExtractor;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;

import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CargoRelationalDbRepoImpl extends CommonCargoRepo {

    private static final String INSERT_CARGO = "INSERT INTO CARGO "
            + "(ID, "
            + "NAME, "
            + "WEIGHT, "
            + "ENTITY_TYPE, "
            + "FOOD_EXPIRATION_DATE, "
            + "FOOD_STORE_TEMPERATURE,"
            + "CLOTHERS_SIZE,"
            + "CLOTHERS_MATERIAL)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        String sql = "SELECT * FROM CARGO WHERE NAME = ?";
        return QueryWrapper.select(sql, CargoMapper::mapCargo, ps -> {
            ps.setString(1, name);
        }).toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> search(CargoSearchCondition searchCondition) {
        String sql = "SELECT * FROM CARGO";

        if (searchCondition.needSorting()) {
            String orderBy = searchCondition.getSortFields()
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.joining(","));
            sql += " ORDER BY " + orderBy + " " + searchCondition.getOrderType();
        }

        return QueryWrapper.select(sql, (ResultSetExtractor<Cargo>) CargoMapper::mapCargo);
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        String sql = "SELECT * FROM CARGO WHERE ID = ?";
        return QueryWrapper.selectOne(sql,
                CargoMapper::mapCargo,
                ps -> {
                    ps.setLong(1, id);
                });
    }

    @Override
    public void save(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        QueryWrapper.executeUpdate(INSERT_CARGO, ps -> {
            this.mapCargoToPreparedStatement(ps, cargo);
        });
    }

    @Override
    public void save(Collection<Cargo> cargos) {
        cargos.forEach(c -> c.setId(IdGenerator.generateId()));
        QueryWrapper.executeUpdateAsBatch(INSERT_CARGO, cargos, this::mapCargoToPreparedStatement);
    }

    @Override
    public void save(Collection<Cargo> cargos, Connection connection) {
        cargos.forEach(c -> c.setId(IdGenerator.generateId()));
        QueryWrapper.executeUpdateAsBatch(INSERT_CARGO,
                connection, false, cargos,
                this::mapCargoToPreparedStatement);
    }

    private void mapCargoToPreparedStatement(PreparedStatement ps, Cargo cargo) throws SQLException {
        int index = 0;
        ps.setLong(++index, cargo.getId());
        ps.setString(++index, cargo.getName());
        ps.setInt(++index, cargo.getWeight());
        ps.setString(++index, cargo.getCargoType().toString());

        if (cargo instanceof FoodCargo) {
            FoodCargo foodCargo = (FoodCargo) cargo;
            ps.setTimestamp(++index, Timestamp.valueOf(foodCargo.getExpirationDate()));
            ps.setInt(++index, foodCargo.getStoreTemperature());
        } else {
            ps.setNull(++index, Types.TIMESTAMP);
            ps.setNull(++index, Types.INTEGER);
        }

        if (cargo instanceof ClothersCargo) {
            ClothersCargo clothersCargo = (ClothersCargo) cargo;
            ps.setString(++index, clothersCargo.getSize());
            ps.setString(++index, clothersCargo.getMaterial());
        } else {
            ps.setNull(++index, Types.VARCHAR);
            ps.setNull(++index, Types.VARCHAR);
        }
    }

    @Override
    public boolean update(Cargo entity) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        int affected = QueryWrapper.executeUpdate("DELETE FROM CARGO WHERE ID = ?", ps -> {
            ps.setLong(1, id);
        });

        return affected > 0;
    }

    @Override
    public List<Cargo> getAll() {
        return QueryWrapper
                .select("SELECT * FROM CARGO", (ResultSetExtractor<Cargo>) CargoMapper::mapCargo);
    }

    @Override
    public int countAll() {
        return QueryWrapper.selectOne("SELECT COUNT(*) AS CNT FROM CARGO",
                (rs) -> rs.getInt("CNT")).orElse(0);
    }

}
