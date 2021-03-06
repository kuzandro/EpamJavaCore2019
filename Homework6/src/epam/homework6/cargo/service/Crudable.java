package epam.homework6.cargo.service;

import epam.homework6.cargo.domain.Cargo;
import epam.homework6.storage.Storage;

public interface Crudable {
    public Cargo get(long id, Storage storage);
    public void add(Cargo cargo, Storage storage);
    public void delete(long id, Storage storage);
}
