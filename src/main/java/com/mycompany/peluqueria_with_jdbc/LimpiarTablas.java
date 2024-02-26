package com.mycompany.peluqueria_with_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LimpiarTablas {
    public static void main(String[] args) {
        limpiar();
    }
  
  private static Connection newConnection() throws SQLException {

    Properties properties = new Properties();

    // nota: si tu clase no se llama Main (e.g. LimpiarTablas), debes cambiar esa palabra acontinuación
    try (InputStream inputStream = LimpiarTablas.class.getClassLoader().getResourceAsStream("database.properties")) {

      // Si el archivo properties NO se encuentra en la carpeta src\main\resources\
      // entonces crea valores por defecto
      if (inputStream == null) {
        System.out.println("Archivo properties no encontrado. Usando valores por defecto.");

        System.out.println("Conexión Exitosa, con valores por defecto");
        // Retorna una conexión
        return DriverManager.getConnection(Peluqueria_with_jdbc.URL, Peluqueria_with_jdbc.USER, Peluqueria_with_jdbc.PASSWORD); 
        // OJO: getConnection() genera IOExceptionse, pero se pasa al siguiente metodo para su manejo
      }

      // Si el archivo properties SÍ se encuentra, intenta cargarlo
      properties.load(inputStream); // OJO: genera IOExceptionse

      String url = properties.getProperty("url");
      String user = properties.getProperty("user");
      String password = properties.getProperty("password");

      System.out.println("Conexión Exitosa. con valores de properties");
      // Retorna una conexión
      return DriverManager.getConnection(url, user, password);
      // OJO: getConnection() genera IOExceptionse, pero se pasa al siguiente metodo para su manejo
    } catch (IOException ex) {
      // Error al cargar el archivo de propiedades
      throw new SQLException("Error al cargar archivo de configuración: " + ex.getMessage());
    }
  }

  public static void limpiar() {

    try (Connection conn = newConnection();
        Statement stmt = conn.createStatement()) {
      int count;
      count = stmt.executeUpdate("DELETE FROM cita;");
      System.out.println("cantidad filas eliminadas en citas: " + count);

      count = stmt.executeUpdate("DELETE FROM servicio");
      System.out.println("cantidad filas eliminadas en servicio: " + count);

      count = stmt.executeUpdate("DELETE FROM horario_trabajo");
      System.out.println("cantidad filas eliminadas en horario_trabajo: " + count);

      count = stmt.executeUpdate("DELETE FROM empleado");
      System.out.println("cantidad filas eliminadas en empleado: " + count);

      count = stmt.executeUpdate("DELETE FROM peluqueria");
      System.out.println("cantidad filas eliminadas en peluqueria: " + count);

      count = stmt.executeUpdate("DELETE FROM cliente");
      System.out.println("cantidad filas eliminadas en cliente: " + count);

      count = stmt.executeUpdate("DELETE FROM acceso");
      System.out.println("cantidad filas eliminadas en acceso: " + count);

      count = stmt.executeUpdate("DELETE FROM persona");
      System.out.println("cantidad filas eliminadas en persona: " + count);

    } catch (SQLException ex) {
      Logger.getLogger(LimpiarTablas.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
