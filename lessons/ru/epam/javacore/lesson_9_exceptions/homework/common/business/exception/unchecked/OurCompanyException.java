package ru.epam.javacore.lesson_9_exceptions.homework.common.business.exception.unchecked;

public class OurCompanyException extends RuntimeException {

  public OurCompanyException(String message) {
    super(message);
  }
}
