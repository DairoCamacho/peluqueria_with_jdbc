package com.mycompany.peluqueria_with_jdbc.logica;

public class Persona {

  private int id;
  private String nombre;
  private String apellido;
  private String telefono;

  public Persona() {}

  public Persona(int id, String nombre, String apellido, String telefono) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
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
   * @return the apellido
   */
  public String getApellido() {
    return apellido;
  }

  /**
   * @param apellido the apellido to set
   */
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return "Persona{"
        + "id="
        + getId()
        + ", nombre="
        + getNombre()
        + ", apellido="
        + getApellido()
        + ", telefono="
        + getTelefono()
        + '}';
  }
}
