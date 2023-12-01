package com.empresa.iglesia.repository;

import com.empresa.iglesia.model.Asistente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenteRepositorio extends CrudRepository<Asistente, Integer> {
}
