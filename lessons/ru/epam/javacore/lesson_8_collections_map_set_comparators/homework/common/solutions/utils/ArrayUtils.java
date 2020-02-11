package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.solutions.utils;

public final class ArrayUtils {

  private ArrayUtils() {
  }

  public static void copyArray(Object[] src, Object[] dest) {
    System.arraycopy(src, 0, dest, 0, src.length);
  }

  public static void printArray(Object[] arr) {
    for (Object obj : arr) {
      if (obj != null) {
        System.out.println(obj);
      }
    }
  }

  public static void removeElement(Object[] arr, int index) {
    System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
  }

}