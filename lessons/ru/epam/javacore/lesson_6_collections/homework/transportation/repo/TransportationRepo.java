package ru.epam.javacore.lesson_6_collections.homework.transportation.repo;

import ru.epam.javacore.lesson_6_collections.homework.common.business.repo.CommonRepo;
import ru.epam.javacore.lesson_6_collections.homework.transportation.domain.Transportation;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);
}
