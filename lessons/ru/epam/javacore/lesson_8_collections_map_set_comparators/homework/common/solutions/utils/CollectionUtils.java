package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.solutions.utils;

import java.util.Collection;

public final class CollectionUtils {

  private CollectionUtils() {

  }

  public static void printCollection(Collection<?> collection) {
    for (Object obj : collection) {
      System.out.println(obj.toString());
    }
  }

  public static boolean isNotEmpty(Collection<?> collection) {
    return collection != null && !collection.isEmpty();
  }

}
