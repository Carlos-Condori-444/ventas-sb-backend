package com.sva.cm.api_ventas.controller;


import com.sva.cm.api_ventas.model.entity.Asignacion;
import com.sva.cm.api_ventas.service.IAsigancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AsignacionController {
    @Autowired
    private IAsigancion asignacionService;

    @PostMapping("asignacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Asignacion create(@RequestBody Asignacion asignacion){
        return asignacionService.save(asignacion);
    }

    @PutMapping("asignacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Asignacion update(@RequestBody Asignacion asignacion){
        return asignacionService.save(asignacion);
    }

    @DeleteMapping("asignacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Asignacion asignacionDelete = asignacionService.findById(id);
        asignacionService.delete(asignacionDelete);
    }

    @GetMapping("asignacion/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Asignacion showById(@PathVariable Integer id){
        return asignacionService.findById(id);
    }

    // Todos los usuarios
    @GetMapping("asignaciones")
    @ResponseStatus(HttpStatus.OK)
    public List<Asignacion> findAll(){
        return asignacionService.findAll();
    }

    // CRUD endpoints...

    @GetMapping("asignacion/supervisor/{supervisorId}/vendedores")
    @ResponseStatus(HttpStatus.OK)
    public List<Asignacion> getVendedoresBySupervisor(@PathVariable Integer supervisorId) {
        return asignacionService.findBySupervisorId(supervisorId);
    }

    @GetMapping("asignacion/supervisor/{supervisorId}/vendedores/count")
    public Map<String, Integer> countVendedoresBySupervisor(@PathVariable Integer supervisorId) {
        Integer count = asignacionService.countVendedoresBySupervisorId(supervisorId);
        return Map.of("totalVendedores", count);
    }
}
