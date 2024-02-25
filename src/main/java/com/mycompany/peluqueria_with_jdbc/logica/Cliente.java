package com.mycompany.peluqueria_with_jdbc.logica;

public class Cliente extends Persona {
  private String tipo;

  public Cliente() {}

  public Cliente(String tipo) {
    this.tipo = tipo;
  }

  public Cliente(String tipo, int id, String nombre, String apellido, String telefono) {
    super(id, nombre, apellido, telefono);
    this.tipo = tipo;
  }

  /**
   * @return the tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * @param tipo the tipo to set
   */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "Cliente{"
        + "id="
        + getId()
        + ", nombre='"
        + getNombre()
        + '\''
        + ", apellido='"
        + getApellido()
        + '\''
        + ", telefono='"
        + getTelefono()
        + '\''
        + ", tipo='"
        + tipo
        + "\'}";
  }
}
