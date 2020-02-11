package ru.epam.javacore.lesson_24_db_web.homework.transportation.repo;

import ru.epam.javacore.lesson_24_db_web.homework.common.business.repo.CommonRepo;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo<Transportation, Long> {
  List<Transportation> getAllFetchingCargoAndCarrier();
}
