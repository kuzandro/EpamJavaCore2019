package epam.homework6.cargo.repo;

import epam.homework6.storage.Storage;
import epam.homework6.cargo.domain.Cargo;

public class CargoCrudRepo implements Crudable {
    public Cargo get(long id, Storage storage) {
        return storage.getCargoById(id);
    }

    public void add(Cargo cargo, Storage storage) {
        storage.addCargo(cargo);
    }

    public void delete(long id, Storage storage) {
        storage.deleteCargoById(id);
    }
}
