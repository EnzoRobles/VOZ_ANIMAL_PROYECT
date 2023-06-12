package com.example.voz_animal_proyect.encargados.repository;

import com.example.voz_animal_proyect.formularios.model.SolicitudVisita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudVisita, Long> {

}
