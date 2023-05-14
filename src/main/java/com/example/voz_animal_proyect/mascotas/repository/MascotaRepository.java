package com.example.voz_animal_proyect.mascotas.repository;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MascotaRepository extends JpaRepository<Mascotas,Long>{
}
