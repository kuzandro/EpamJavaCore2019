package ru.epam.javacore.lesson_5_oop_continue.homework.common.utils;

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

}