package ru.epam.javacore.lesson_8_collections_map_set_comparators.homework.common.business.domain;

public abstract class BaseEntity {
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
