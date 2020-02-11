package ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc;

@FunctionalInterface
public interface JdbcConsumer<T> {

    void consume(T t) throws Exception;
}
