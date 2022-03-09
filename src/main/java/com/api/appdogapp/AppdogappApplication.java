package com.api.appdogapp;

import com.api.appdogapp.entities.Mascota;
import com.api.appdogapp.repositorys.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class AppdogappApplication implements WebMvcConfigurer{
    @Autowired
    public MascotaRepository repository;

    @PostMapping("/mascotas")
    @ResponseStatus(HttpStatus.CREATED)
    public Mascota addMascota(@RequestBody Mascota mascota){
        System.out.println(mascota.toString());
        return repository.save(mascota);
    }

    @GetMapping("/mascotas")
    public List<Mascota> getMascotas(){
        return repository.findAll();
    }

    @GetMapping("/mascotas/{id}")
    public Optional<Mascota> showMascota(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMascota(@PathVariable int id){
        System.out.println("id: "+id);
        repository.deleteById(id);
    }
    @PutMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mascota updateMascota(@RequestBody Mascota mascota, @PathVariable int id){
        System.out.println(mascota.toString());
        Mascota mascotaActual=repository.findById(id).orElseThrow();

        mascotaActual.setTipo(mascota.getTipo());
        mascotaActual.setNombre(mascota.getNombre());
        return repository.save(mascotaActual);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/health")
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }

    public static void main(String[] args) {
        SpringApplication.run(AppdogappApplication.class, args);
    }

}
