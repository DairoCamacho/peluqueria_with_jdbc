package com.mycompany.peluqueria_with_jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
  private static final String CONFIG_FILE = "archivo.properties";
  private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/siac";
  private static final String DEFAULT_USER = "root";
  private static final String DEFAULT_PASSWORD = "miBaseDeDatos123...";

  private static Connection createConnection(String url, String user, String password)
      throws SQLException {
    /* No se necesita try-with-resources aquí ya que la conexion
    se cierra en el try-with-resource del método main */
    Connection connection = DriverManager.getConnection(url, user, password);
    System.out.println("Conexión creada");
    return connection;
  }

  private static Connection getConnectionWithDefaults() throws SQLException {
    String defaultUrl = DEFAULT_URL;
    String defaultUser = DEFAULT_USER;
    String defaultPassword = DEFAULT_PASSWORD;
    return createConnection(defaultUrl, defaultUser, defaultPassword);
  }

  private static Properties loadProperties() {
    // OJO: FileInputStream() podria generar FileNotFoundException
    try (InputStream inputStream = new FileInputStream(CONFIG_FILE)) {
      Properties properties = new Properties();
      // OJO: properties.load() genera IOExceptionse
      properties.load(inputStream);
      return properties;
    } catch (IOException e) {
      System.out.println(
          "Archivo properties no encontrado o error al cargarlo. Usando valores por defecto.");
      return null; // Indica que se deben usar valores por defecto
    }
  }

  private static Connection getConnection() throws SQLException {
    Properties properties = loadProperties();
    if (properties != null) {
      String url = properties.getProperty("url");
      String user = properties.getProperty("user");
      String password = properties.getProperty("password");
      System.out.println("se usan los valores del archivo properties");
      return createConnection(url, user, password);
    } else {
      return getConnectionWithDefaults();
    }
  }

  public static void main(String[] args) {

    try (Connection conn = getConnection();
        Statement stmt = conn.createStatement()) {
      int count;
      count = stmt.executeUpdate("DELETE FROM cita;");
      System.out.println("cantidad filas eliminadas en citas: " + count);
    } catch (SQLException ex) {
      Logger.getLogger(LimpiarTablas.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}