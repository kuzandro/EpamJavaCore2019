package ru.epam.javacore.lesson_6_collections.homework.transportation.repo.impl;

import ru.epam.javacore.lesson_6_collections.homework.common.solutions.utils.ArrayUtils;
import ru.epam.javacore.lesson_6_collections.homework.storage.IdGenerator;
import ru.epam.javacore.lesson_6_collections.homework.storage.Storage;
import ru.epam.javacore.lesson_6_collections.homework.transportation.domain.Transportation;
import ru.epam.javacore.lesson_6_collections.homework.transportation.repo.TransportationRepo;

import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.transportationIndex;

public class TransportationDefaultRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        if (transportationIndex == Storage.transportations.length) {
            Transportation[] newTransportations =
                    new Transportation[Storage.transportations.length * 2];
            ArrayUtils.copyArray(Storage.transportations, newTransportations);
            Storage.transportations = newTransportations;
        }

        transportation.setId(IdGenerator.generateId());
        Storage.transportations[transportationIndex] = transportation;
        transportationIndex++;
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : Storage.transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
