package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona,Integer> {
}
