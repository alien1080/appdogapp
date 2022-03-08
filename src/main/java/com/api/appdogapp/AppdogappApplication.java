package com.api.appdogapp;

import com.api.appdogapp.entities.Mascota;
import com.api.appdogapp.repositorys.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@RestController
public class AppdogappApplication implements WebMvcConfigurer{
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
