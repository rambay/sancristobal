package com.empresa.iglesia.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;
    private String nombre_evento;
    private String direccion;
    private String descripcion;
    private LocalDate fecha;
    private double precio;
    private int aforoMaximo;
    private String estado_evento;
    @OneToMany(mappedBy = "id_evento")
    private List<Registro> registro_evento;

    public Evento() {
    }

    public Evento(int id_evento, String nombre_evento, String direccion, String descripcion, LocalDate fecha, double precio, int aforoMaximo, String estado_evento, List<Registro> registro_evento) {
        this.id_evento = id_evento;
        this.nombre_evento = nombre_evento;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.aforoMaximo = aforoMaximo;
        this.estado_evento = estado_evento;
        this.registro_evento = registro_evento;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public String getEstado_evento() {
        return estado_evento;
    }

    public void setEstado_evento(String estado_evento) {
        this.estado_evento = estado_evento;
    }

    public List<Registro> getRegistro_evento() {
        return registro_evento;
    }

    public void setRegistro_evento(List<Registro> registro_evento) {
        this.registro_evento = registro_evento;
    }
}
