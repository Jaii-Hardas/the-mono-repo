package db_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

  static Connection con;
  static Statement stmt;

  static {
    try {
      con =
          DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/directory_service_db", "root", "Jaii@1515");
      stmt = con.createStatement();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void executeQuery(String query) {
    try {
      stmt.execute(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static ResultSet executeQueryGetResult(String query) {
    ResultSet resultset = null;
    try {
      resultset = stmt.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return resultset;
  }
}