package com.api.appdogapp;

import com.api.appdogapp.entities.Mascota;
import com.api.appdogapp.repositorys.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class AppdogappApplication {
    @Autowired
    public MascotaRepository repository;

    @PostMapping("/mascota")
    public Mascota addMascota(@RequestBody Mascota mascota){
        System.out.println(mascota.toString());
        return repository.save(mascota);
    }
    @GetMapping("/mascotas")
    public List<Mascota> getMascotas(){
        return repository.findAll();
    }

    @DeleteMapping("/mascota")
    public void removeMascota(@RequestParam int id){
        System.out.println("id: "+id);
        repository.deleteById(id);
    }
    @PutMapping("/mascota")
    public Mascota removeMascota(@RequestBody Mascota mascota){
        System.out.println(mascota.toString());
        repository.deleteById(mascota.getId());
        return repository.save(mascota);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppdogappApplication.class, args);
    }

}
