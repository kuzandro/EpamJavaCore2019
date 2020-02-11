package ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface PreparedStatementIdentityFunc {

    PreparedStatement applyParamsAndGet(PreparedStatement ps) throws Exception;
}
