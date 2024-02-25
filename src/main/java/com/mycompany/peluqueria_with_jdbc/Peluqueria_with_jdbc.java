package com.mycompany.peluqueria_with_jdbc;

import com.mycompany.peluqueria_with_jdbc.persistencia.ClienteController;
import com.mycompany.peluqueria_with_jdbc.vista.Fronted;

public class Peluqueria_with_jdbc {

    public static void main(String[] args) {
        /*
        NOTA: Ejercicio realizado en JDK 17, NetBeans v17,
        usando el driver de mysql llamado mysql-connector-j version 8.3.0
        y la dependencia commons-configuration2 version 2.8.0 para menejo de 
        properties. Consultar archivo pom.xml
         */
        ClienteController clienteController = new ClienteController();

        // Metodo para eliminar el contenido de todas las tablas
        System.out.println("*********** ELMINAR TABLAS ***********");
        LimpiarTablas.limpiar();
        
        // probar metodo create
        System.out.println("\n*********** CREAR 3 CLIENTES ***********\n");
        // Recibimos el Cliente desde el front Y lo pasamos al controlador
        // Para este ejemplo serian tres clientes creados aleatoriamente
        clienteController.create(Fronted.crearCliente());
        clienteController.create(Fronted.crearCliente());
        clienteController.create(Fronted.crearCliente());

        // Probar metodo findAll
        System.out.println("\n*********** CONSULTAR TODOS LOS CLIENTES ***********\n");
        clienteController.FindAll();

        // Probar metodo update (edit)
        System.out.println("\n*********** MODIFICAR EL CLIENTE 1 ***********\n");
        System.out.println("Nuevos datos para el cliente 1: \n" + Fronted.modificarCliente().toString());
        clienteController.update(Fronted.modificarCliente());

        // Probar metodo find
        System.out.println("\n*********** CONSULTAR EL CLIENTE 1 ***********\n");
        clienteController.find(1);

        // Probar metodo detele
        System.out.println("\n*********** ELIMINAR EL CLIENTE 3 ***********\n");
        clienteController.delete(3);

        // Probar metodo findAll
        System.out.println("\n*********** CONSULTAR TODOS LOS CLIENTES ***********\n");
        clienteController.FindAll();


    }
}
