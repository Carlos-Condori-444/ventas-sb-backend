package com.sva.cm.api_ventas.service.impl;

import com.sva.cm.api_ventas.model.dao.UsuarioDao;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario autenticar(String username, String password) {
        // Buscar usuario por username
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Verificar password (simple comparación)
        if (!usuario.getPasswordHash().equals(password)) {
            throw new RuntimeException("Password incorrecto");
        }

        // Verificar si está activo
        if (!usuario.getActivo()) {
            throw new RuntimeException("Usuario inactivo");
        }

        return usuario; // Si todo está bien, retornar el usuario
    }
}
