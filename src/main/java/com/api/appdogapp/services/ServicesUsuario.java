package com.api.appdogapp.services;

import com.api.appdogapp.models.Usuario;
import com.api.appdogapp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicesUsuario {
    private final UsuarioRepository userRepository;

    @Autowired
    public ServicesUsuario(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Usuario saveUser(Usuario user){
        return userRepository.save(user);
    }
    public Optional<Usuario> getUsuario(Long id){
        return userRepository.findById(id);
    }

}
