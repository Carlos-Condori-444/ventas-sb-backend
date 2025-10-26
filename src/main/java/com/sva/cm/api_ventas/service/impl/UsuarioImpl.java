package com.sva.cm.api_ventas.service.impl;

import com.sva.cm.api_ventas.model.dao.UsuarioDao;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    //traer todos los usuarios
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    // UPDATE
    @Override
    public Usuario update(Usuario usuario) {
        if (usuario.getId() == null) {
            throw new RuntimeException("ID es requerido para actualizar");
        }

        Usuario usuarioExistente = usuarioDao.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuario.getId()));

        // Actualizar solo campos modificables
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPasswordHash(usuario.getPasswordHash());
        usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());
        usuarioExistente.setActivo(usuario.getActivo());

        return usuarioDao.save(usuarioExistente);
    }


}
