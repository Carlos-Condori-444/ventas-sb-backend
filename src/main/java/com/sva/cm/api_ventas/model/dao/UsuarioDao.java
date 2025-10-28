package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer> {

    //métodos para el servicio IAuthService
    Usuario findByUsername(String username);
}
