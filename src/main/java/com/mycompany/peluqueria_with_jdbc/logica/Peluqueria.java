package com.mycompany.peluqueria_with_jdbc.logica;

public class Peluqueria {
  private int id;
  private String nombre;
  private String telefono;
  private String direccion;
  private String barrio;
  private String ciudad;
  private String pais;

  public Peluqueria() {}

  public Peluqueria(
      int id,
      String nombre,
      String telefono,
      String direccion,
      String barrio,
      String ciudad,
      String pais) {
    this.id = id;
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.barrio = barrio;
    this.ciudad = ciudad;
    this.pais = pais;
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

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the barrio
   */
  public String getBarrio() {
    return barrio;
  }

  /**
   * @param barrio the barrio to set
   */
  public void setBarrio(String barrio) {
    this.barrio = barrio;
  }

  /**
   * @return the ciudad
   */
  public String getCiudad() {
    return ciudad;
  }

  /**
   * @param ciudad the ciudad to set
   */
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * @return the pais
   */
  public String getPais() {
    return pais;
  }

  /**
   * @param pais the pais to set
   */
  public void setPais(String pais) {
    this.pais = pais;
  }

  @Override
  public String toString() {
    return "Peluqueria{"
        + "id="
        + getId()
        + ", nombre="
        + getNombre()
        + ", telefono="
        + getTelefono()
        + ", direccion="
        + getDireccion()
        + ", barrio="
        + getBarrio()
        + ", ciudad="
        + getCiudad()
        + ", pais="
        + getPais()
        + '}';
  }
}
