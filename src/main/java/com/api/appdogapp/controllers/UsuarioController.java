package com.api.appdogapp.controllers;

import com.api.appdogapp.models.Usuario;
import com.api.appdogapp.services.ServicesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ServicesUsuario userService;

    private PasswordEncoder passwordEncoder;

    @Bean
    public static PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public UsuarioController(ServicesUsuario userService) {
        this.userService = userService;
    }

    @PostMapping("/registrarme")
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        System.out.println(usuario.toString());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userService.saveUser(usuario);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id){
    return userService.getUsuario(id);
    }
}
