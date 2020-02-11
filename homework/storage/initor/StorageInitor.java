package ru.epam.javacore.lesson_24_db_web.homework.storage.initor;

import ru.epam.javacore.lesson_24_db_web.homework.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
