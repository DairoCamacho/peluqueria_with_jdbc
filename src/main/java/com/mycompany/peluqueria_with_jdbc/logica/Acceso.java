package com.mycompany.peluqueria_with_jdbc.logica;

import java.time.LocalDateTime;

public class Acceso {
  private int personaId;
  private String email;
  private String contraseña;
  private LocalDateTime fechaActualizacion;

  public Acceso() {}

  public Acceso(int personaId, String email, String contraseña, LocalDateTime fechaActualizacion) {
    this.personaId = personaId;
    this.email = email;
    this.contraseña = contraseña;
    this.fechaActualizacion = fechaActualizacion;
  }

  /**
   * @return the personaId
   */
  public int getPersonaId() {
    return personaId;
  }

  /**
   * @param personaId the personaId to set
   */
  public void setPersonaId(int personaId) {
    this.personaId = personaId;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the contraseña
   */
  public String getContraseña() {
    return contraseña;
  }

  /**
   * @param contraseña the contraseña to set
   */
  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  /**
   * @return the fechaActualizacion
   */
  public LocalDateTime getFechaActualizacion() {
    return fechaActualizacion;
  }

  /**
   * @param fechaActualizacion the fechaActualizacion to set
   */
  public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

  @Override
  public String toString() {
    return "Acceso{"
        + "personaId="
        + getPersonaId()
        + ", email="
        + getEmail()
        + ", contrase\u00f1a="
        + getContraseña()
        + ", fechaActualizacion="
        + getFechaActualizacion()
        + '}';
  }
}
