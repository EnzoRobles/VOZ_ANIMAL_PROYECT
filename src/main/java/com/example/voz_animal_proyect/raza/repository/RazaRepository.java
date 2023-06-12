package com.example.voz_animal_proyect.raza.repository;

import com.example.voz_animal_proyect.raza.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RazaRepository extends JpaRepository<Raza,Long> {

    List<Raza> findByTamanoLessThanEqualAndHorasLessThanEqualAndPersonalidadAndHabilidadAndViviendaLessThanEqualAndHogarLessThanEqual(
            int tamano, int horas, String personalidad, String habilidad, int vivienda, int hogar);
}
