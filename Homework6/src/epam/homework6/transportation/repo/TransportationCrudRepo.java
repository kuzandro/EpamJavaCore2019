package epam.homework6.transportation.repo;

import epam.homework6.storage.Storage;
import epam.homework6.transportation.domain.Transportation;

public class TransportationCrudRepo implements Crudable {
    public Transportation get(long id, Storage storage) {
        return storage.getTransportationById(id);
    }

    public void add(Transportation transportation, Storage storage) {
        storage.addTransportation(transportation);
    }

    public void delete(long id, Storage storage) {
        storage.deleteTransportationById(id);
    }
}