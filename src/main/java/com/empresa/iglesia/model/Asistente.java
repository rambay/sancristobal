package com.empresa.iglesia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombres;
    private String dni;
    private String telefono;
    private String email;
    @OneToMany(mappedBy = "id_asistente")
    private List<Registro> registro_asistente;

    public Asistente() {
    }

    public Asistente(int id, String nombres, String dni, String telefono, String email, List<Registro> registro_asistente) {
        this.id = id;
        this.nombres = nombres;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.registro_asistente = registro_asistente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Registro> getRegistro_asistente() {
        return registro_asistente;
    }

    public void setRegistro_asistente(List<Registro> registro_asistente) {
        this.registro_asistente = registro_asistente;
    }
}
