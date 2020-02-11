package ru.epam.javacore.lesson_24_db_web.homework.common.solutions.repo.jdbc;

import org.apache.commons.collections4.CollectionUtils;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.datasource.HikariCpDataSource;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.exception.unchecked.SqlException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class QueryWrapper {

  private static final int BATCH_EXECUTE_THRESHOLD = 10;

  public static <T> List<T> select(String sql, Connection connection,
      ResultSetExtractor<T> extractor) throws SqlException {
    try {
      try (PreparedStatement ps = connection.prepareStatement(sql);
          ResultSet resultSet = ps.executeQuery()) {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
          result.add(extractor.extract(resultSet));
        }

        return result;
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, Connection connection,
      ResultSetToExtractor<T> extractor) throws SqlException {

    try {
      try (PreparedStatement ps = connection.prepareStatement(sql);
          ResultSet resultSet = ps.executeQuery()) {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
          extractor.extract(resultSet, result);
        }

        return result;
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, ResultSetToExtractor<T> extractor)
      throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return select(sql, connection, extractor);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }


  public static <T> List<T> select(String sql, ResultSetExtractor<T> extractor)
      throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return select(sql, connection, extractor);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, Connection connection, ResultSetExtractor<T> mapper,
      PreparedStatementIdentityFunc psIdentityFunc) throws SqlException {
    try {
      try (PreparedStatement ps = psIdentityFunc
          .applyParamsAndGet(connection.prepareStatement(sql));
          ResultSet resultSet = ps.executeQuery()) {

        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
          result.add(mapper.extract(resultSet));
        }

        return result;
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, ResultSetExtractor<T> mapper,
      PreparedStatementIdentityFunc psIdentityFunc) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return select(sql, connection, mapper, psIdentityFunc);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, Connection connection, ResultSetExtractor<T> mapper,
      PreparedStatementConsumer psConsumer) throws SqlException {
    try {
      JdbcSupplier<PreparedStatement> supplier = () -> {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        psConsumer.consume(preparedStatement);
        return preparedStatement;
      };

      try (PreparedStatement ps = supplier.get();
          ResultSet resultSet = ps.executeQuery()) {

        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
          result.add(mapper.extract(resultSet));
        }

        return result;
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> List<T> select(String sql, ResultSetExtractor<T> mapper,
      PreparedStatementConsumer psConsumer) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return select(sql, connection, mapper, psConsumer);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, Connection connection,
      ResultSetExtractor<T> extractor) throws SqlException {
    try {
      try (PreparedStatement ps = connection.prepareStatement(sql);
          ResultSet resultSet = ps.executeQuery()) {
        if (resultSet.next()) {
          return Optional.of(extractor.extract(resultSet));
        } else {
          return Optional.empty();
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor)
      throws SqlException {
    try {
      try {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
          return selectOne(sql, connection, extractor);
        }
      } catch (Exception e) {
        throw new SqlException(e);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, Connection connection,
      ResultSetExtractor<T> extractor, PreparedStatementIdentityFunc psIdentityFunc)
      throws SqlException {
    try {
      try (PreparedStatement ps = psIdentityFunc
          .applyParamsAndGet(connection.prepareStatement(sql));
          ResultSet resultSet = ps.executeQuery()) {
        if (resultSet.next()) {
          return Optional.of(extractor.extract(resultSet));
        } else {
          return Optional.empty();
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor,
      PreparedStatementIdentityFunc psIdentityFunc) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return selectOne(sql, connection, extractor, psIdentityFunc);
      }
    } catch (
        Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, Connection connection,
      ResultSetExtractor<T> extractor, PreparedStatementConsumer consumer) throws SqlException {
    try {
      JdbcSupplier<PreparedStatement> supplier = () -> {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        consumer.consume(preparedStatement);
        return preparedStatement;
      };

      try (PreparedStatement ps = supplier.get();
          ResultSet resultSet = ps.executeQuery()) {
        if (resultSet.next()) {
          return Optional.of(extractor.extract(resultSet));
        } else {
          return Optional.empty();
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor,
      PreparedStatementConsumer consumer) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return selectOne(sql, connection, extractor, consumer);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static int executeUpdate(String sql, Connection connection,
      PreparedStatementIdentityFunc psIdentityFunc) throws SqlException {
    try {
      try (PreparedStatement ps = psIdentityFunc
          .applyParamsAndGet(connection.prepareStatement(sql))) {
        return ps.executeUpdate();
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static int executeUpdate(String sql, Connection connection,
      PreparedStatementConsumer psConsumer) throws SqlException {
    try {
      PreparedStatementSupplier supplier = () -> {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        psConsumer.consume(preparedStatement);
        return preparedStatement;
      };
      try (PreparedStatement ps = supplier.get()) {
        return ps.executeUpdate();
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static int executeUpdate(String sql, Connection connection) throws SqlException {
    try {
      try (PreparedStatement ps = connection.prepareStatement(sql)) {
        return ps.executeUpdate();
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static int executeUpdate(String sql, PreparedStatementIdentityFunc psIdentityFunc)
      throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return executeUpdate(sql, connection, psIdentityFunc);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static int executeUpdate(String sql, PreparedStatementConsumer psConsumer)
      throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return executeUpdate(sql, connection, psConsumer);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> executeUpdateReturningGeneratedKey(String sql,
      Connection connection,
      PreparedStatementIdentityFunc psIdentityFunc,
      ResultSetExtractor<T> keyExtractor) throws SqlException {
    try {
      try (PreparedStatement ps = psIdentityFunc.applyParamsAndGet(
          connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))) {
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
          if (rs.next()) {
            return Optional.of(keyExtractor.extract(rs));
          } else {
            return Optional.empty();
          }
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> executeUpdateReturningGeneratedKey(String sql,
      PreparedStatementIdentityFunc psIdentityFunc,
      ResultSetExtractor<T> keyExtractor) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return executeUpdateReturningGeneratedKey(sql, connection, psIdentityFunc, keyExtractor);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> executeUpdateReturningGeneratedKey(String sql,
      Connection connection,
      PreparedStatementConsumer psConsumer,
      ResultSetExtractor<T> keyExtractor) throws SqlException {
    try {
      JdbcSupplier<PreparedStatement> supplier = () -> {
        PreparedStatement preparedStatement = connection
            .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        psConsumer.consume(preparedStatement);
        return preparedStatement;
      };

      try (PreparedStatement ps = supplier.get()) {
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
          if (rs.next()) {
            return Optional.of(keyExtractor.extract(rs));
          } else {
            return Optional.empty();
          }
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> Optional<T> executeUpdateReturningGeneratedKey(String sql,
      PreparedStatementConsumer psConsumer,
      ResultSetExtractor<T> keyExtractor) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        return executeUpdateReturningGeneratedKey(sql, connection, psConsumer, keyExtractor);
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> void executeUpdateAsBatch(String sql, Connection connection,
      boolean execInTransaction, Collection<T> batchItems,
      PreparedStatementBiConsumer<T> psConsumer) throws SqlException {
    try {
      if (CollectionUtils.isNotEmpty(batchItems)) {
        boolean rememberAutoCommit = connection.getAutoCommit();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          int counter = 0;
          boolean needFlush = false;

          for (T item : batchItems) {
            needFlush = true;
            counter++;
            psConsumer.consume(ps, item);
            ps.addBatch();

            if (counter % BATCH_EXECUTE_THRESHOLD == 0) {
              ps.executeBatch();
              counter = 0;
            }
          }

          if (needFlush && counter > 0) {
            ps.executeBatch();
          }

          if (!execInTransaction) {
            connection.commit();
          }
        } finally {
          connection.setAutoCommit(rememberAutoCommit);
        }
      }
    } catch (Exception e) {
      throw new SqlException(e);
    }
  }

  public static <T> void executeUpdateAsBatch(String sql, Collection<T> batchItems,
      PreparedStatementBiConsumer<T> psConsumer) throws SqlException {
    try {
      try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
        executeUpdateAsBatch(sql, connection, false, batchItems, psConsumer);
      }

    } catch (Exception e) {
      throw new SqlException(e);
    }
  }
}
