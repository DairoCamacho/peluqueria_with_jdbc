package com.mycompany.peluqueria_with_jdbc.logica;

import java.time.LocalDate;

public class Empleado extends Persona {
  private String cargo;
  private LocalDate fechaContratacion;
  private LocalDate fechaSalida;
  private int peluqueriaId;

  public Empleado() {}

  public Empleado(
      String cargo, LocalDate fechaContratacion, LocalDate fechaSalida, int peluqueriaId) {
    //    super();
    this.cargo = cargo;
    this.fechaContratacion = fechaContratacion;
    this.fechaSalida = fechaSalida;
    this.peluqueriaId = peluqueriaId;
  }

  /**
   * @return the cargo
   */
  public String getCargo() {
    return cargo;
  }

  /**
   * @param cargo the cargo to set
   */
  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  /**
   * @return the fechaContratacion
   */
  public LocalDate getFechaContratacion() {
    return fechaContratacion;
  }

  /**
   * @param fechaContratacion the fechaContratacion to set
   */
  public void setFechaContratacion(LocalDate fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
  }

  /**
   * @return the fechaSalida
   */
  public LocalDate getFechaSalida() {
    return fechaSalida;
  }

  /**
   * @param fechaSalida the fechaSalida to set
   */
  public void setFechaSalida(LocalDate fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  /**
   * @return the peluqueriaId
   */
  public int getPeluqueriaId() {
    return peluqueriaId;
  }

  /**
   * @param peluqueriaId the peluqueriaId to set
   */
  public void setPeluqueriaId(int peluqueriaId) {
    this.peluqueriaId = peluqueriaId;
  }

  @Override
  public String toString() {
    return "Empleado{"
        + "cargo="
        + getCargo()
        + ", fechaContratacion="
        + getFechaContratacion()
        + ", fechaSalida="
        + getFechaSalida()
        + ", peluqueriaId="
        + getPeluqueriaId()
        + '}';
  }
}
