package epam.homework6.carrier.repo;

import epam.homework6.carrier.domain.Carrier;
import epam.homework6.storage.Storage;

public interface Crudable {
    public Carrier get(long id, Storage storage);
    public void add(Carrier cargo, Storage storage);
    public void delete(long id, Storage storage);
}
