package com.empresa.iglesia.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Asistente id_asistente;
    @ManyToOne
    private Evento id_evento;
    private LocalDate fecha;

    public Registro() {
    }

    public Registro(Asistente id_asistente, Evento id_evento, LocalDate fecha) {
        this.id_asistente = id_asistente;
        this.id_evento = id_evento;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asistente getId_asistente() {
        return id_asistente;
    }

    public void setId_asistente(Asistente id_asistente) {
        this.id_asistente = id_asistente;
    }

    public Evento getId_evento() {
        return id_evento;
    }

    public void setId_evento(Evento id_evento) {
        this.id_evento = id_evento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
