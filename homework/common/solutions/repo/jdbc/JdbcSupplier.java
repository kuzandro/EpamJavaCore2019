package ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc;

public interface JdbcSupplier<T> {
    T get() throws Exception;
}
