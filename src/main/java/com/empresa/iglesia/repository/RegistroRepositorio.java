package com.empresa.iglesia.repository;

import com.empresa.iglesia.model.Registro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepositorio extends CrudRepository<Registro, Integer> {
}
