package ru.epam.javacore.lesson_24_db_web.homework.cargo.service;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.exception.unckecked.CargoDeleteConstraintViolationException;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.repo.CargoRepo;
import ru.epam.javacore.lesson_24_db_web.homework.cargo.search.CargoSearchCondition;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.CarrierRepo;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.datasource.HikariCpDataSource;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;
    private CarrierRepo carrierRepo;

    public CargoServiceImpl(CargoRepo cargoRepo, CarrierRepo carrierRepo) {
        this.carrierRepo = carrierRepo;
        this.cargoRepo = cargoRepo;
    }

    @Override
    public void save(Cargo cargo) {
        cargoRepo.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        if (id != null) {
            return cargoRepo.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return cargoRepo.getByIdFetchingTransportations(id);
        }
        return Optional.empty();
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public int countAll() {
        return this.cargoRepo.countAll();
    }

    @Override
    public List<Cargo> findByName(String name) {
        Cargo[] found = cargoRepo.findByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Cargo> cargoOptional = this.getByIdFetchingTransportations(id);

        if (cargoOptional.isPresent()) {
            List<Transportation> transportations = cargoOptional.get().getTransportations();
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CargoDeleteConstraintViolationException(id);
            }

            return cargoRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    @Override
    public boolean update(Cargo cargo) {
        if (cargo != null) {
            return cargoRepo.update(cargo);
        }

        return false;
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return cargoRepo.search(cargoSearchCondition);
    }

    @Override
    public void saveCargosWithCarriers(Collection<Cargo> cargos, Collection<Carrier> carriers) {
        Connection conn = null;
        Boolean bufConnecitonAutoCommit = null;
        try {
            conn = HikariCpDataSource.getInstance().getConnection();
            bufConnecitonAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            if (!carriers.isEmpty()) {
                carrierRepo.save(carriers, conn);
            }
            if (!cargos.isEmpty()) {
                cargoRepo.save(cargos, conn);
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    if (bufConnecitonAutoCommit != null) {
                        conn.setAutoCommit(bufConnecitonAutoCommit);
                    }
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
