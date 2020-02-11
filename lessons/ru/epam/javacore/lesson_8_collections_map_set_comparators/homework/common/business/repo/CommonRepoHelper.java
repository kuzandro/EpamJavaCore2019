package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.repo;

import ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.domain.BaseEntity;

public final class CommonRepoHelper {

  private CommonRepoHelper() {

  }

  public static Integer findEntityIndexInArrayStorageById(BaseEntity[] data, long entityId) {
    for (int i = 0; i < data.length; i++) {
      if (Long.valueOf(entityId).equals(data[i].getId())) {
        return i;
      }
    }

    return null;
  }
}
