package com.sva.cm.api_ventas.model.dtos;

import com.sva.cm.api_ventas.model.entity.Usuario;

public class LoginResponse {
    private Integer id;
    private String username;
    private Usuario.TipoUsuario tipoUsuario; // Cambia a Enum
    private String message;

    // Constructor con Enum
    public LoginResponse(Integer id, String username, Usuario.TipoUsuario tipoUsuario, String message) {
        this.id = id;
        this.username = username;
        this.tipoUsuario = tipoUsuario;
        this.message = message;
    }
    // Constructor vacío
    public LoginResponse() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario.TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Usuario.TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}