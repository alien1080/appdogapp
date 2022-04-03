package com.api.appdogapp.controllers;

import com.api.appdogapp.models.Solicitud;
import com.api.appdogapp.services.SolicitudServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SolicitudController {
    private final SolicitudServices solicitudServices;

    public SolicitudController(SolicitudServices solicitudServices) {
        this.solicitudServices = solicitudServices;
    }
    @PostMapping("/solicitud")
    public Solicitud saveSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudServices.saveSolicitud(solicitud);
    }
    @DeleteMapping("/solicitud/{id}")
    public void removeSolicitud(@PathVariable long id){
        solicitudServices.removeSolicitud(id);
    }

    @GetMapping("/solicitud/{id}")
    public Optional<Solicitud> getSolicitud(@PathVariable long id){
        return solicitudServices.getSolicitud(id);
    }
    @GetMapping("/solicitudes")
    public List<Solicitud> getSolicitudes(){
        return solicitudServices.getSolicitudes();
    }
}
