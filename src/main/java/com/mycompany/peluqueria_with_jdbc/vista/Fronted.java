package com.mycompany.peluqueria_with_jdbc.vista;

import com.mycompany.peluqueria_with_jdbc.logica.Cita;
import com.mycompany.peluqueria_with_jdbc.logica.Cliente;
import com.mycompany.peluqueria_with_jdbc.logica.Peluqueria;
import java.time.LocalDate;
import java.time.LocalTime;

public class Fronted {

  public Fronted() {}

  private static int contadorIncremental = 0;

  // metodo que selecciona aleatoriamente 1 de los tipos de clientes
  private static String generarTipoClienteAleatorio() {
    String[] tipoCliente = {"ocasional", "recurrente", "premium"};
    String clienteAleatorio = tipoCliente[(int) (Math.random() * tipoCliente.length)];
    return clienteAleatorio;
  }

  // Método para generar una palabra de entre 5 y 10 letras de forma aleatoria
  private static String generarPalabraAleatoria() {
    // Arreglo con las letras del alfabeto
    String[] letras = {
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r",
      "s", "t", "u", "v", "w", "x", "y", "z"
    };
    /*
    GENERAR UN NÚMERO ALEATORIO ENTRE 5 y 7
    Math.random() genera un número aleatorio entre 0 y 1 (excluyendo 1).
    se multiplica por 3: calculo de la diferencia entre 7 y 5, sumándole 1 para obtener un rango
    de 3 valores (de 5 a 7)
    (int) convierte el resultado de la operación a un número entero.
    Finalmente se suma 5 al resultado para obtener un rango minimo de 5.
    */
    int longitudPalabra = (int) (Math.random() * 3) + 5;

    // Generar una palabra aleatoria de la longitud especificada
    String palabraAleatoria = "";
    for (int i = 0; i < longitudPalabra; i++) {
      int indiceAleatorio = (int) (Math.random() * letras.length);
      palabraAleatoria += letras[indiceAleatorio];
    }
    // Devolver la palabra aleatoria
    return palabraAleatoria;
  }

  // genera un cliente con datos aleatorios y de id incremetal
  public static Cliente crearCliente() {
    // Incrementar el contador
    contadorIncremental++;
    // crear un cliente
    Cliente cliente =
        new Cliente(
            generarTipoClienteAleatorio(),
            contadorIncremental,
            "NOM" + generarPalabraAleatoria(),
            "APE" + generarPalabraAleatoria(),
            "TEL" + generarPalabraAleatoria());
    return cliente;
  }

  // modificamos el cliente de id = 1
  public static Cliente modificarCliente() {
    // cliente modificado
    Cliente cliente =
        new Cliente("TipoModificado", 1, "NombreModificado", "ApellidoModificado", "TelModifi");
    return cliente;
  }

  // Eliminar un cliente usando su id
  public static int eliminarCliente(int id) {
    return id;
  }

  public static Peluqueria crearPeluqueria() {
    // crear un peluquería
    Peluqueria peluqueria =
        new Peluqueria(
            1,
            "NOM" + generarPalabraAleatoria(),
            "TEL" + generarPalabraAleatoria(),
            "DIR" + generarPalabraAleatoria(),
            "BAR" + generarPalabraAleatoria(),
            "CIU" + generarPalabraAleatoria(),
            "PAIS" + generarPalabraAleatoria());
    return peluqueria;
  }

  public static Cita crearCita() {
    // creamos una cita
    LocalDate fechaCita = LocalDate.of(2024, contadorIncremental, contadorIncremental);
    LocalTime horaCita = LocalTime.of(10, 0);
    Cita cita = new Cita(1, fechaCita, horaCita, 1, 1, 1);
    return cita;
  }
}
