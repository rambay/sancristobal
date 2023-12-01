package com.empresa.iglesia.service;

import com.empresa.iglesia.model.Evento;
import com.empresa.iglesia.repository.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    EventoRepositorio er;

    public List<Evento> listarEventos() {
        return (List<Evento>) er.findAll();
    }
    public Evento buscarEventoPorID(Integer id) {
        return er.findById(id).orElse(null);
    }

    public void guardarEvento(Evento ev) {
        er.save(ev);
    }


}
