package com.api.appdogapp.repositorys;

import com.api.appdogapp.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
