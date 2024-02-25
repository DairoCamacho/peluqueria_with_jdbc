package com.mycompany.peluqueria_with_jdbc.logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
  private int id;
  private LocalDate fecha;
  private LocalTime hora;
  private int clienteId;
  private int empleadoId;
  private int servicioId;

  public Cita() {}

  public Cita(
      int id, LocalDate fecha, LocalTime hora, int clienteId, int empleadoId, int servicioId) {
    this.id = id;
    this.fecha = fecha;
    this.hora = hora;
    this.clienteId = clienteId;
    this.empleadoId = empleadoId;
    this.servicioId = servicioId;
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
   * @return the fecha
   */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  /**
   * @return the hora
   */
  public LocalTime getHora() {
    return hora;
  }

  /**
   * @param hora the hora to set
   */
  public void setHora(LocalTime hora) {
    this.hora = hora;
  }

  /**
   * @return the clienteId
   */
  public int getClienteId() {
    return clienteId;
  }

  /**
   * @param clienteId the clienteId to set
   */
  public void setClienteId(int clienteId) {
    this.clienteId = clienteId;
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
   * @return the servicioId
   */
  public int getServicioId() {
    return servicioId;
  }

  /**
   * @param servicioId the servicioId to set
   */
  public void setServicioId(int servicioId) {
    this.servicioId = servicioId;
  }

  @Override
  public String toString() {
    return "Cita{"
        + "id="
        + getId()
        + ", fecha="
        + getFecha()
        + ", hora="
        + getHora()
        + ", clienteId="
        + getClienteId()
        + ", empleadoId="
        + getEmpleadoId()
        + ", servicioId="
        + getServicioId()
        + '}';
  }
}
