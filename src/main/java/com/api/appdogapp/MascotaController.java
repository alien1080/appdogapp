package com.api.appdogapp;

import com.api.appdogapp.models.Mascota;
import com.api.appdogapp.services.ServicesMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final ServicesMascota servicesMascota;

    @Autowired
    public MascotaController(ServicesMascota servicesMascota) {
        this.servicesMascota = servicesMascota;
    }

    @PostMapping()
    public Mascota addMascota(@RequestPart("mascota") Mascota mascota, @RequestPart("imagen") MultipartFile file)throws IOException {
        System.out.println(mascota.toString());
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        mascota.setImagen(file.getBytes());
        return servicesMascota.saveMascota(mascota);
    }

    @GetMapping()
    public List<Mascota> getMascotas(){
        return servicesMascota.getMascotas();
    }

    @GetMapping("/{id}")
    public Optional<Mascota> showMascota(@PathVariable int id){
        return servicesMascota.showMascota(id);
    }

    @DeleteMapping("/{id}")
    public String removeMascota(@PathVariable int id){
        System.out.println("id: "+id);
        return servicesMascota.removeMascota(id);
    }
    @PutMapping()
    public Mascota updateMascota(@RequestBody Mascota mascota){
        return servicesMascota.updateMascota(mascota);
    }
}
