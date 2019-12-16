package epam.homework6.carrier.service;

import epam.homework6.carrier.domain.Carrier;
import epam.homework6.storage.Storage;

public class CarrierCrudService implements Crudable {
    public Carrier get(long id, Storage storage) {
        return storage.getCarrierById(id);
    }

    public void add(Carrier carrier, Storage storage) {
        storage.addCarrier(carrier);
    }

    public void delete(long id, Storage storage) {
        storage.deleteCarrierById(id);
    }
}