package com.empresa.iglesia.repository;

import com.empresa.iglesia.model.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends CrudRepository<Administrador, Integer> {
}
