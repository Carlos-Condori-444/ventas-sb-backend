package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Asignacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AsignacionDao extends CrudRepository<Asignacion,Integer> {
    List<Asignacion> findBySupervisorIdAndActivoTrue(Integer supervisorId);

    Integer countBySupervisorIdAndActivoTrue(Integer supervisorId);
}
