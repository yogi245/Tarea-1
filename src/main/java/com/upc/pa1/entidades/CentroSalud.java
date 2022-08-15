package com.upc.pa1.entidades;

import javax.persistence.*;

// codigo (autonumérico correlativo)
// nombre del centro de salud
// tipo (hospital o clínica)
// calificación de infraestructura (valor entre 1 y 100)
// calificación de servicios (valor entre 1 y 100)
// cuenta con ambulancias propias o no
@Entity
@Table(name = "TB_CENTROSALUD")
public class CentroSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private int calificacionInfraestructura;
    private int calificacionServicio;
    private String ambulancia;

    private transient double calificacion;

    public CentroSalud(){}

    public CentroSalud(Long codigo, String nombre, String tipo, int calificacionInfraestructura, int calificacionServicio, String ambulancia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calificacionInfraestructura = calificacionInfraestructura;
        this.calificacionServicio = calificacionServicio;
        this.ambulancia = ambulancia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalificacionInfraestructura() {
        return calificacionInfraestructura;
    }

    public void setCalificacionInfraestructura(int calificacionInfraestructura) {
        this.calificacionInfraestructura = calificacionInfraestructura;
    }

    public int getCalificacionServicio() {
        return calificacionServicio;
    }

    public void setCalificacionServicio(int calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
    }

    public String getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(String ambulancia) {
        this.ambulancia = ambulancia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
