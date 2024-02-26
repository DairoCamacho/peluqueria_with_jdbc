package com.mycompany.peluqueria_with_jdbc.persistencia;

import com.mycompany.peluqueria_with_jdbc.Peluqueria_with_jdbc;
import com.mycompany.peluqueria_with_jdbc.logica.Cliente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    private static Connection newConnection() throws SQLException {
        Properties properties = new Properties();
        // Nota: el .properties debe estar en la ruta \nombre_del_proyecto\archivo.properties
        try (InputStream inputStream = new FileInputStream("archivo.properties")) {
            // OJO: FileInputStream() genera FileNotFoundException

            // Si el archivo properties SÍ se encuentra, intenta cargarlo
            properties.load(inputStream); // OJO: properties.load() genera IOExceptionse

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            System.out.println("Conexión Exitosa. con valores de properties");
            // Retorna una conexión
            return DriverManager.getConnection(url, user, password);
        } catch (FileNotFoundException ex) { // Captura específica para FileNotFoundException
            // Si el archivo properties NO se encuentra, se usan valores por defecto
            System.out.println("Archivo properties no encontrado. Usando valores por defecto.");
            String defaultUrl = Peluqueria_with_jdbc.URL;
            String defaultUser = Peluqueria_with_jdbc.USER;
            String defaultPassword = Peluqueria_with_jdbc.PASSWORD;

            System.out.println("Conexión Exitosa. con valores por defecto");
            // Retorna una conexión
            return DriverManager.getConnection(defaultUrl, defaultUser, defaultPassword);

        } catch (IOException ex) { // Captura para otras IOException
            throw new SQLException("Error al cargar archivo de configuración: " + ex.getMessage());
        }
    }

    // ESTE MÉTODO HACE USO DE UNA TRANSACCIÓN
    public void create(Cliente cliente) {

        // establecemos la conexión
        try (Connection conn = newConnection()) {
            conn.setAutoCommit(false);

            // preparamos la plantilla con la querySQL para crear una persona
            String sqlPersona = "INSERT INTO persona (id, nombre, apellido, telefono) VALUES(?,?,?,?);";
            // preparamos la plantilla con la querySQL para crear un cliente
            String sqlCliente = "INSERT INTO cliente(id, tipo) VALUES(?,?);";

            try {
                // CREAMOS UNA PERSONA
                PreparedStatement stmt = conn.prepareStatement(sqlPersona);
                // pasamos cada uno de los parametros que necesita la querySQL
                stmt.setInt(1, cliente.getId());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getApellido());
                stmt.setString(4, cliente.getTelefono());

                // ejecutamos la query
                var resultado1 = stmt.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado1 == 1 ? "Modificación persona exitosa": "Modificación persona fallida");

                // CREAMOS UN CLIENTE
                stmt = conn.prepareStatement(sqlCliente);
                // pasamos cada uno de los parametros que necesita la querySQL
                stmt.setInt(1, cliente.getId());
                stmt.setString(2, cliente.getTipo());

                // ejecutamos la query
                var resultado2 = stmt.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado2 == 1 ? "Modificación cliente exitosa": "Modificación cliente fallida");

                conn.commit(); // confirmamos las operaciones de la Transacción

            } catch (SQLException ex) {
                conn.rollback(); // si algo falla deshace los cambio y libera la DB
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void find(int id) {
        try (Connection conn = newConnection();) {
            // preparamos la plantilla con la querySQL
            String sql
                    = "SELECT p.id,p.nombre,p.apellido,p.telefono,c.tipo FROM cliente AS c INNER JOIN persona AS p ON c.id = p.id WHERE c.id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            // ejecutamos la query y almacenamos la respuesta
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1)); // busca la columna 1
                cliente.setNombre(rs.getString(2)); // busca la columna 2
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setTipo(rs.getString(5));
                System.out.println(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void FindAll() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try (Connection conn = newConnection(); Statement stmt = conn.createStatement()) {
            String sql
                    = "SELECT p.id,p.nombre,p.apellido,p.telefono,c.tipo FROM cliente AS c INNER JOIN persona AS p ON c.id = p.id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1)); // busca la columna 1
                cliente.setNombre(rs.getString(2)); // busca la columna 2
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setTipo(rs.getString(5));
                listaClientes.add(cliente);
                System.out.println(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ESTE MÉTODO HACE USO DE UNA TRANSACCIÓN
    public void update(Cliente cliente) {
        try (Connection conn = newConnection()) {
            // apagamos las confirmaciones automaticas para hacer una transacción
            conn.setAutoCommit(false);

            // preparamos la plantilla con la querySQL para actualizar una persona
            String sqlPersona = "UPDATE persona SET nombre = ?, apellido=?, telefono=? WHERE id = ?";

            // preparamos la plantilla con la querySQL para actualizar un cliente
            String sqlCliente = "UPDATE cliente SET tipo = ? WHERE id = ?";

            try (PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona); PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {

                // ACTUALIZAMOS EN LA TABLA PERSONA
                // setiamos los parametros que necesita la query
                stmtPersona.setString(1, cliente.getNombre());
                stmtPersona.setString(2, cliente.getApellido());
                stmtPersona.setString(3, cliente.getTelefono());
                stmtPersona.setInt(4, cliente.getId());
                // ejecutamos la query
                var resultado1 = stmtPersona.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado1 == 1 ? "Modificación persona exitosa": "Modificación persona fallida");

                // ACTUALIZAMOS EN LA TABLA CLIENTE
                // setiamos los parametros que necesita la query
                stmtCliente.setString(1, cliente.getTipo());
                stmtCliente.setInt(2, cliente.getId());
                // ejecutamos la query
                var resultado2 = stmtCliente.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado2 == 1 ? "Modificación cliente exitosa": "Modificación cliente fallida");

                conn.commit(); // confirmamos las operaciones de la Transacción
            } catch (SQLException ex) {
                conn.rollback(); // si algo falla deshace los cambio y libera la DB
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ESTE MÉTODO HACE USO DE UNA TRANSACCIÓN
    public void delete(int id) {
        try (Connection conn = newConnection()) {

            String sqlCliente = "DELETE FROM cliente WHERE id = ?";
            String sqlPersona = "DELETE FROM persona WHERE id = ?";

            try (PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente); PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona)) {
                // apagamos las confirmaciones automaticas para hacer una transacción
                conn.setAutoCommit(false);

                stmtCliente.setInt(1, id);
                // ejecutamos la query
                var resultado1 = stmtCliente.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado1 == 1 ? "Eliminación cliente exitosa": "Eliminación cliente fallida");

                stmtPersona.setInt(1, id);
                // ejecutamos la query
                var resultado2 = stmtPersona.executeUpdate();
                // mostramos el resultado en pantalla
                System.out.println(resultado2 == 1 ? "Eliminación persona exitosa": "Eliminación persona fallida");

                conn.commit(); // confirmamos las operaciones de la Transacción
            } catch (SQLException ex) {
                conn.rollback(); // si algo falla deshace los cambio y libera la DB
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
