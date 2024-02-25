package com.mycompany.peluqueria_with_jdbc.persistencia;

import com.mycompany.peluqueria_with_jdbc.Peluqueria_with_jdbc;
import com.mycompany.peluqueria_with_jdbc.logica.Cita;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitaController {

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

  public void create(Cita cita) {

    // establecemos la conexión
    try (Connection conn = newConnection()) {

      // preparamos la plantilla con la querySQL
      String sql =
          "INSERT INTO cita(id, fecha, hora, cliente_id, empleado_id, servicio_id) VALUES(?,?,?,?,?,?);";

      try (PreparedStatement stmt = conn.prepareStatement(sql)) {

        // pasamos cada uno de los parametros que necesita la querySQL
        stmt.setInt(1, cita.getId());
        stmt.setDate(2, java.sql.Date.valueOf(cita.getFecha()));
        stmt.setTime(3, java.sql.Time.valueOf(cita.getHora()));
        stmt.setInt(4, cita.getClienteId());
        stmt.setInt(5, cita.getEmpleadoId());
        stmt.setInt(6, cita.getServicioId());

        // ejecutamos la query
        var resultado = stmt.executeUpdate();
        // mostramos el resultado en pantalla
        System.out.println("Resultado creación: " + resultado);
      } catch (SQLException ex) {
        Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
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

  public List<Cita> FindAll() {
    try (Connection conn = newConnection()) {
      // pendiente por implementar

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    }

    List<Cita> listaCitas = new ArrayList<>();
    return listaCitas;
  }

  public void update(Cita cita) {
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
