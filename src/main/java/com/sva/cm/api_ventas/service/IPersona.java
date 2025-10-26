package com.sva.cm.api_ventas.service;

import com.sva.cm.api_ventas.model.entity.Persona;

import java.util.List;

public interface IPersona {

    Persona save(Persona persona);

    Persona findById(Integer id);

    void delete(Persona persona);

    List<Persona> findAll();
}
