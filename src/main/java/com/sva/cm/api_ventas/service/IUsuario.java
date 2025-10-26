package com.sva.cm.api_ventas.service;

import com.sva.cm.api_ventas.model.entity.Usuario;

import java.util.List;

//definimos intenciones
public interface IUsuario {

    Usuario save(Usuario usuario);

    Usuario findById(Integer id);

    void delete(Usuario usuario);

    //traer todos los uduarios
    List<Usuario> findAll();

    //update
    Usuario update(Usuario usuario);
}
