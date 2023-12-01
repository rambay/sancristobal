package com.empresa.iglesia.repository;

import com.empresa.iglesia.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends CrudRepository<Evento, Integer> {
}
