package com.api.appdogapp.services;

import com.api.appdogapp.models.Mascota;
import com.api.appdogapp.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesMascota {

    private final MascotaRepository repository;

    @Autowired
    public ServicesMascota(MascotaRepository repository) {
        this.repository = repository;
    }

    public  Mascota saveMascota(Mascota mascota){
        return repository.save(mascota);
    }

    public List<Mascota> getMascotas(){
        return repository.findAll();
    }

    public Optional<Mascota> showMascota(int id){
        return repository.findById(id);
    }

    public String removeMascota(int id){
        System.out.println("id: "+id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Remove successful";
        }
        else return "Remove not success, pet not exits in database";
    }

    public Mascota updateMascota(Mascota mascota){
        return repository.save(mascota);
    }
}
