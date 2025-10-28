package com.sva.cm.api_ventas.service;

import com.sva.cm.api_ventas.model.entity.Usuario;

public interface IAuthService {
    Usuario autenticar(String username, String password);
}
