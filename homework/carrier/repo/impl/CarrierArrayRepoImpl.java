package ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.impl;


import static ru.epam.javacore.lesson_24_db_web.homework.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static ru.epam.javacore.lesson_24_db_web.homework.storage.Storage.carrierArray;
import static ru.epam.javacore.lesson_24_db_web.homework.storage.Storage.carrierIndex;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.repo.CarrierRepo;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.ArrayUtils;
import ru.epam.javacore.lesson_24_db_web.homework.storage.IdGenerator;

import java.sql.Connection;
import java.util.*;

public class CarrierArrayRepoImpl implements CarrierRepo {

    private static final Carrier[] EMPTY_CARRIER_ARRAY = new Carrier[0];

    @Override
    public void save(Carrier carrier) {
        if (carrierIndex == carrierArray.length) {
            Carrier[] newCarriers = new Carrier[carrierArray.length * 2];
            ArrayUtils.copyArray(carrierArray, newCarriers);
            carrierArray = newCarriers;
        }

        carrier.setId(IdGenerator.generateId());
        carrierArray[carrierIndex] = carrier;
        carrierIndex++;
    }

    @Override
    public void save(Collection<Carrier> carriers) {
        carriers.forEach(this::save);
    }

    @Override
    public void save(Collection<Carrier> carriers, Connection connection) {
        this.save(carriers);
    }

    @Override
    public boolean update(Carrier carrier) {
        return true;
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {
        Carrier[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
        if (searchResultWithNullableElems == null || searchResultWithNullableElems.length == 0) {
            return EMPTY_CARRIER_ARRAY;
        } else {
            return excludeNullableElementsFromArray(searchResultWithNullableElems);
        }
    }

    private Carrier[] getByNameIncludingNullElements(String name) {
        Carrier[] result = new Carrier[carrierArray.length];

        int curIndex = 0;
        for (Carrier carrier : carrierArray) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }

        return result;
    }


    private Carrier[] excludeNullableElementsFromArray(Carrier[] carriers) {
        int sizeOfArrWithNotNullElems = 0;

        for (Carrier carrier : carriers) {
            if (carrier != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_CARRIER_ARRAY;
        } else {
            Carrier[] result = new Carrier[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Carrier carrier : carriers) {
                if (carrier != null) {
                    result[index++] = carrier;
                }
            }

            return result;
        }
    }

    @Override
    public List<Carrier> getAll() {
        Carrier[] carriers = excludeNullableElementsFromArray(carrierArray);
        return carriers.length == 0 ? Collections.emptyList() : Arrays.asList(carrierArray);
    }

    @Override
    public int countAll() {
        return this.getAll().size();
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        for (Carrier carrier : carrierArray) {
            if (carrier != null && carrier.getId().equals(id)) {
                return Optional.of(carrier);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Integer> indexToDeleteOptional = findEntityIndexInArrayStorageById(carrierArray, id);

        return indexToDeleteOptional.map(i -> {
            ArrayUtils.removeElement(carrierArray, i);
            return true;
        }).orElse(false);
    }
}
