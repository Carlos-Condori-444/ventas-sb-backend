package com.sva.cm.api_ventas.controller;

import com.sva.cm.api_ventas.model.dtos.LoginRequest;
import com.sva.cm.api_ventas.model.dtos.LoginResponse;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = authService.autenticar(loginRequest.getUsername(), loginRequest.getPassword());

            LoginResponse response = new LoginResponse(
                    usuario.getId(),
                    usuario.getUsername(),
                    usuario.getTipoUsuario(),
                    "Login exitoso"
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(Map.of("message", "Logout exitoso"));
    }
}
