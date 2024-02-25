package com.mycompany.peluqueria_with_jdbc.logica;

import java.time.LocalTime;

public class Servicio {
  private int id;
  private String nombre;
  private int precio;
  private LocalTime duracion;
  private int peluqueriaid;

  public Servicio() {}

  public Servicio(int id, String nombre, int precio, LocalTime duracion, int peluqueriaid) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.duracion = duracion;
    this.peluqueriaid = peluqueriaid;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the precio
   */
  public int getPrecio() {
    return precio;
  }

  /**
   * @param precio the precio to set
   */
  public void setPrecio(int precio) {
    this.precio = precio;
  }

  /**
   * @return the duracion
   */
  public LocalTime getDuracion() {
    return duracion;
  }

  /**
   * @param duracion the duracion to set
   */
  public void setDuracion(LocalTime duracion) {
    this.duracion = duracion;
  }

  /**
   * @return the peluqueriaid
   */
  public int getPeluqueriaid() {
    return peluqueriaid;
  }

  /**
   * @param peluqueriaid the peluqueriaid to set
   */
  public void setPeluqueriaid(int peluqueriaid) {
    this.peluqueriaid = peluqueriaid;
  }

  @Override
  public String toString() {
    return "Servicio{"
        + "id="
        + id
        + ", nombre="
        + nombre
        + ", precio="
        + precio
        + ", duracion="
        + duracion
        + ", peluqueriaid="
        + peluqueriaid
        + '}';
  }
}
