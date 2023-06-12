package com.example.voz_animal_proyect.mascotas.repository;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.raza.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascotas,Long>{

    List<Mascotas> findByRazaAndAlbergue(Raza raza, Albergue albergue);
    List<Mascotas> findByRaza(Raza raza);

}
