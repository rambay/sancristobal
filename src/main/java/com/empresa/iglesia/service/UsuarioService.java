package com.empresa.iglesia.service;

import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio ur;

    public List<Asistente> listarUsuarios() {
        return (List<Asistente>) ur.findAll();
    }

    public Asistente listarUsuario(Integer id) {
        return ur.findById(id).orElse(null);
    }

}
