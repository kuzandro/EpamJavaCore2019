package epam.homework6.transportation.repo;

import epam.homework6.storage.Storage;
import epam.homework6.transportation.domain.Transportation;

public interface Crudable {
    public Transportation get(long id, Storage storage);
    public void add(Transportation transportation, Storage storage);
    public void delete(long id, Storage storage);
}
