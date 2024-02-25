package com.mycompany.peluqueria_with_jdbc.persistencia;

import com.mycompany.peluqueria_with_jdbc.Peluqueria_with_jdbc;
import com.mycompany.peluqueria_with_jdbc.logica.Peluqueria;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeluqueriaController {

  private static Connection newConnection() throws SQLException {
    // Establece la URL de la base de datos MySQL
    String url = "jdbc:mysql://localhost:3306/siac";
    String user = "root";
    String password = "miBaseDeDatos123...";

    // Intenta establecer la conexión
    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("Conexión exitosa.");
      return conn;
    } catch (SQLException ex) {
      System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
      throw ex;
    }
  }

  public void create(Peluqueria peluqueria) {

    // establecemos la conexión
    try (Connection conn = newConnection()) {

      // preparamos la plantilla con la querySQL
      String sql =
          "INSERT INTO cita(id, nombre, telefono, direccion, barrio, ciudad, pais) VALUES(?,?,?,?,?,?,?);";

      try (PreparedStatement stmt = conn.prepareStatement(sql)) {

        // pasamos cada uno de los parametros que necesita la querySQL
        stmt.setInt(1, peluqueria.getId());
        stmt.setString(2, peluqueria.getNombre());
        stmt.setString(3, peluqueria.getTelefono());
        stmt.setString(4, peluqueria.getDireccion());
        stmt.setString(5, peluqueria.getBarrio());
        stmt.setString(6, peluqueria.getCiudad());
        stmt.setString(7, peluqueria.getPais());

        // ejecutamos la query
        var resultado = stmt.executeUpdate();
        // mostramos el resultado en pantalla
        System.out.println("Resultado creación: " + resultado);
      } catch (SQLException ex) {
        Logger.getLogger(PeluqueriaController.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (SQLException ex) {
      Logger.getLogger(Peluqueria_with_jdbc.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void find(int id) {
    try (Connection conn = newConnection()) {
      // pendiente por implementar

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public List<Peluqueria> FindAll() {
    try (Connection conn = newConnection()) {
      // pendiente por implementar

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    }
    List<Peluqueria> listaPeluquerias = new ArrayList<>();
    return listaPeluquerias;
  }

  public void update(Peluqueria peluqueria) {
    try (Connection conn = newConnection()) {
      // pendiente por implementar

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void delete(int id) {
    try (Connection conn = newConnection()) {
      // pendiente por implementar

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
