package com.sva.cm.api_ventas.service;


import com.sva.cm.api_ventas.model.entity.Asignacion;
import com.sva.cm.api_ventas.model.entity.Usuario;

import java.util.List;

public interface IAsigancion {
    //guardar asigancion
    Asignacion save(Asignacion asignacion);

    //buscar asigancion por id
    Asignacion findById(Integer id);

    //borrar asigancion
    void delete(Asignacion asignacion);

    //traer todos las asignaciones
    List<Asignacion> findAll();

    // Metodo específico de negocio
    List<Asignacion> findBySupervisorId(Integer supervisorId);
    List<Usuario> findVendedoresBySupervisorId(Integer supervisorId); // Opcional: solo vendedores
    Integer countVendedoresBySupervisorId(Integer supervisorId); // Opcional: solo contar
}
