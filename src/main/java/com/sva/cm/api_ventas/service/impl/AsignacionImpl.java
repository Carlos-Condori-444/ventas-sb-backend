package com.sva.cm.api_ventas.service.impl;

import com.sva.cm.api_ventas.model.dao.AsignacionDao;
import com.sva.cm.api_ventas.model.entity.Asignacion;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IAsigancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignacionImpl  implements IAsigancion {

    @Autowired
    private AsignacionDao asignacionDao;

    @Transactional
    @Override
    public Asignacion save(Asignacion asignacion) {
        return asignacionDao.save(asignacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Asignacion findById(Integer id) {
        return asignacionDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Asignacion asignacion) {
        asignacionDao.delete(asignacion);
    }

    //traer todos los Asignacion
    @Transactional(readOnly = true)
    @Override
    public List<Asignacion> findAll() {
        return (List<Asignacion>) asignacionDao.findAll();
    }

    // ... otros métodos CRUD ...

    @Transactional(readOnly = true)
    @Override
    public List<Asignacion> findBySupervisorId(Integer supervisorId) {
        return asignacionDao.findBySupervisorIdAndActivoTrue(supervisorId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findVendedoresBySupervisorId(Integer supervisorId) {
        List<Asignacion> asignaciones = asignacionDao.findBySupervisorIdAndActivoTrue(supervisorId);
        return asignaciones.stream()
                .map(Asignacion::getVendedor)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Integer countVendedoresBySupervisorId(Integer supervisorId) {
        return asignacionDao.countBySupervisorIdAndActivoTrue(supervisorId);
    }
}
