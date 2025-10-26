package com.sva.cm.api_ventas.controller;

import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @PostMapping("usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @DeleteMapping("usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Usuario usuarioDelete = usuarioService.findById(id);
        usuarioService.delete(usuarioDelete);
    }

    @GetMapping("usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario showById(@PathVariable Integer id){
        return usuarioService.findById(id);
    }

    // Todos los usuarios
    @GetMapping("usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }
}
