package ru.epam.javacore.lesson_9_exceptions.homework.transportation.repo;

import ru.epam.javacore.lesson_9_exceptions.homework.common.business.repo.CommonRepo;
import ru.epam.javacore.lesson_9_exceptions.homework.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}
