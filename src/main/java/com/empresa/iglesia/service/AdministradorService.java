package com.empresa.iglesia.service;

import com.empresa.iglesia.model.Administrador;
import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.repository.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepositorio ar;

    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) ar.findAll();
    }

    public Administrador listarAdministrador(Integer id) {
        return ar.findById(id).orElse(null);
    }
}
