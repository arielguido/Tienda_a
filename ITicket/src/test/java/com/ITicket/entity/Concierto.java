/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="Concierto")
public class Concierto implements Serializable {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 
 private long id; 
 private String artistaAsociado;
 private String costo;
 private String fecha;
 private String capacidadP;
 private String capacidadL;
 
  @ManyToOne

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtistaAsociado() {
        return artistaAsociado;
    }

    public void setArtistaAsociado(String artistaAsociado) {
        this.artistaAsociado = artistaAsociado;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCapacidadP() {
        return capacidadP;
    }

    public void setCapacidadP(String capacidadP) {
        this.capacidadP = capacidadP;
    }

    public String getCapacidadL() {
        return capacidadL;
    }

    public void setCapacidadL(String capacidadL) {
        this.capacidadL = capacidadL;
    }
  
}
