package com.empresa.iglesia.service;

import com.empresa.iglesia.model.Registro;
import com.empresa.iglesia.repository.RegistroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    RegistroRepositorio rr;

    public void guardarRegistro(Registro nuevoRegistro) {
        rr.save(nuevoRegistro);
    }

    public List<Registro> buscarRegistrosPorId(Integer id) {
        List<Registro> registros = (List<Registro>) rr.findAll();
        List<Registro> registrosEncontrados = new ArrayList<>();

        for (Registro reg : registros) {
            if (reg.getId_evento().getId_evento() == id) {
                registrosEncontrados.add(reg);
            }
        }
        return registrosEncontrados;
    }

    public Registro buscarRegistroPorId(Integer id) {
        Iterable<Registro> registros = rr.findAll();
        Registro registroEncontrado = null;

        for (Registro reg : registros) {
            if (reg.getId_evento().getId_evento() == id) {
                registroEncontrado = reg;
                break;
            }
        }
        return registroEncontrado;
    }
}
