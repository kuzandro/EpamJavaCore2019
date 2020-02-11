package ru.epam.javacore.lesson_24_db_web.homework.common.business.exception.unchecked;

public class OurCompanyUncheckedException extends RuntimeException {

  public OurCompanyUncheckedException(String message) {
    super(message);
  }
}
