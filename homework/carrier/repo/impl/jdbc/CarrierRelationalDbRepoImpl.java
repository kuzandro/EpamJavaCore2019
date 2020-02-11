package ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.impl.jdbc;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.CarrierRepo;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.QueryWrapper;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc.ResultSetExtractor;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CarrierRelationalDbRepoImpl implements CarrierRepo {
    private static final String INSERT_CARRIER = "INSERT INTO CARRIER (ID,NAME,ADDRESS, ENTITY_TYPE) VALUES (?,?,?,?)";

    @Override
    public void save(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        QueryWrapper.executeUpdate(INSERT_CARRIER, ps -> {
            mapCarrierToPreparedStatement(ps, carrier);
        });
    }

    private void mapCarrierToPreparedStatement(PreparedStatement ps, Carrier carrier) throws SQLException {
        int index = 0;
        ps.setLong(++index, carrier.getId());
        ps.setString(++index, carrier.getName());
        ps.setString(++index, carrier.getAddress());
        ps.setString(++index, carrier.getCarrierType().toString());
    }

    @Override
    public void save(Collection<Carrier> carriers) {
        carriers.forEach(c -> c.setId(IdGenerator.generateId()));
        QueryWrapper.executeUpdateAsBatch(INSERT_CARRIER, carriers, this::mapCarrierToPreparedStatement);
    }

    @Override
    public void save(Collection<Carrier> carriers, Connection connection) {
        carriers.forEach(c -> c.setId(IdGenerator.generateId()));
        QueryWrapper.executeUpdateAsBatch(INSERT_CARRIER, connection,
                false, carriers, this::mapCarrierToPreparedStatement);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        String sql = "SELECT * FROM CARRIER WHERE ID = ?";
        return QueryWrapper.selectOne(sql,
                CarrierMapper::mapCarrier,
                ps -> {
                    ps.setLong(1, id);
                });

    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {
        String sql = "SELECT * FROM CARRIER WHERE NAME = ?";
        return QueryWrapper.select(sql, CarrierMapper::mapCarrier, ps -> {
            ps.setString(1, name);
        }).toArray(new Carrier[0]);
    }

    @Override
    public boolean deleteById(Long id) {
        int affected = QueryWrapper.executeUpdate("DELETE FROM CARRIER WHERE ID = ?", ps -> {
            ps.setLong(1, id);
        });

        return affected > 0;
    }

    @Override
    public List<Carrier> getAll() {
        return QueryWrapper
                .select("SELECT * FROM CARRIER", (ResultSetExtractor<Carrier>) CarrierMapper::mapCarrier);
    }

    @Override
    public int countAll() {
        return QueryWrapper.selectOne("SELECT COUNT(*) AS CNT FROM CARRIER",
                (rs) -> rs.getInt("CNT")).orElse(0);
    }

    @Override
    public boolean update(Carrier carrier) {
        return true;
    }
}
