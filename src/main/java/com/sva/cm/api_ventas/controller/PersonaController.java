package com.sva.cm.api_ventas.controller;

import com.sva.cm.api_ventas.model.entity.Persona;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

    @Autowired
    private IPersona personaService;

    @PostMapping("persona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona create(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @PutMapping("persona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @DeleteMapping("persona/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Persona personaDelete = personaService.findById(id);
        personaService.delete(personaDelete);
    }

    @GetMapping("persona/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Persona showById(@PathVariable Integer id){
        return personaService.findById(id);
    }

    @GetMapping("personas")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> findAll(){
        return personaService.findAll();
    }


}
