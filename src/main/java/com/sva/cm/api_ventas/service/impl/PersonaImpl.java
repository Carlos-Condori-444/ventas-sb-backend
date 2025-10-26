package com.sva.cm.api_ventas.service.impl;

import com.sva.cm.api_ventas.model.dao.PersonaDao;
import com.sva.cm.api_ventas.model.entity.Persona;
import com.sva.cm.api_ventas.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaImpl  implements IPersona {

    @Autowired
    private PersonaDao personaDao;

    @Transactional
    @Override
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public Persona findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Persona persona) {
        personaDao.delete(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }
}
