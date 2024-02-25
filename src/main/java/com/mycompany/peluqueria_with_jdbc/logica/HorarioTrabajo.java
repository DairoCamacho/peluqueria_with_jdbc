package com.mycompany.peluqueria_with_jdbc.logica;

import java.time.LocalDateTime;

public class HorarioTrabajo {
  private int id;
  private int empleadoId;
  private LocalDateTime fechaInicio;
  private LocalDateTime fechaFin;

  public HorarioTrabajo() {}

  public HorarioTrabajo(int id, int empleadoId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    this.id = id;
    this.empleadoId = empleadoId;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
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
   * @return the empleadoId
   */
  public int getEmpleadoId() {
    return empleadoId;
  }

  /**
   * @param empleadoId the empleadoId to set
   */
  public void setEmpleadoId(int empleadoId) {
    this.empleadoId = empleadoId;
  }

  /**
   * @return the fechaInicio
   */
  public LocalDateTime getFechaInicio() {
    return fechaInicio;
  }

  /**
   * @param fechaInicio the fechaInicio to set
   */
  public void setFechaInicio(LocalDateTime fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  /**
   * @return the fechaFin
   */
  public LocalDateTime getFechaFin() {
    return fechaFin;
  }

  /**
   * @param fechaFin the fechaFin to set
   */
  public void setFechaFin(LocalDateTime fechaFin) {
    this.fechaFin = fechaFin;
  }

  @Override
  public String toString() {
    return "horarioTrabajo{"
        + "id="
        + getId()
        + ", empleadoId="
        + getEmpleadoId()
        + ", fechaInicio="
        + getFechaInicio()
        + ", fechaFin="
        + getFechaFin()
        + '}';
  }
}
