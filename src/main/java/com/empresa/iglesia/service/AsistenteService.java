package com.empresa.iglesia.service;

import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.repository.AsistenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenteService {

    @Autowired
    AsistenteRepositorio ar;

    public List<Asistente> listarAsistentes() {
        return (List<Asistente>) ar.findAll();
    }

    public void guardarAsistente(Asistente as) {
        ar.save(as);
    }
}
