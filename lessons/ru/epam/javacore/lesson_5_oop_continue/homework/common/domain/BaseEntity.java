package ru.epam.javacore.lesson_5_oop_continue.homework.common.domain;

public abstract class BaseEntity {
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
