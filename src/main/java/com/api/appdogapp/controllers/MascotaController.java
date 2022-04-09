package com.api.appdogapp.controllers;

import com.api.appdogapp.models.Mascota;
import com.api.appdogapp.services.ServicesMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("mascotas")
public class MascotaController {

    private final ServicesMascota servicesMascota;

    @Autowired
    public MascotaController(ServicesMascota servicesMascota) {
        this.servicesMascota = servicesMascota;
    }

    @PostMapping("/guardar")
    public Mascota addMascota(@RequestBody Mascota mascota) {
        System.out.println(mascota.toString());
        return servicesMascota.saveMascota(mascota);
    }

    @GetMapping("/listar")
    public ArrayList<Mascota> getMascotas(){
        return servicesMascota.getMascotas();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Mascota> showMascota(@PathVariable int id){
        return servicesMascota.showMascota(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String removeMascota(@PathVariable int id){
        System.out.println("id: "+id);
        return servicesMascota.removeMascota(id);
    }

    @PutMapping("/actualizar")
    public Mascota updateMascota(@RequestBody Mascota mascota){
        return servicesMascota.updateMascota(mascota);
    }
}
