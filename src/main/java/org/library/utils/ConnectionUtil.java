package org.library.utils;

import java.sql.*;
import java.util.Objects;

public class ConnectionUtil {

  private final static String DB_HOST = PropertiesUtil.get("database.url");
  private final static String DB_USER = PropertiesUtil.get("database.username");
  private final static String DB_PASS = PropertiesUtil.get("database.password");
  private final static String DB_DRIVER = PropertiesUtil.get("database.driver");

  private static Connection connection = null;
  private static ResultSet resultSet = null;

  public static void init() {
    try {
      Class.forName(ConnectionUtil.DB_DRIVER);

      ConnectionUtil.connection = DriverManager.getConnection(
              ConnectionUtil.DB_HOST,
              ConnectionUtil.DB_USER,
              ConnectionUtil.DB_PASS
      );

    } catch (Exception e) {
      LibraryException.getError(e);
    }
  }

  public static ResultSet resultSet(String sql) {
    try {
      if (Objects.isNull(ConnectionUtil.connection)) {
        throw new SQLException();
      }
      
      ConnectionUtil.resultSet = ConnectionUtil.connection
          .prepareStatement(sql).executeQuery();

    } catch (SQLException e) {
      LibraryException.getError(e);
    }

    return ConnectionUtil.resultSet;
  }
}