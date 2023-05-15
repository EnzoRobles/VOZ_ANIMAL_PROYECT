package com.example.voz_animal_proyect.encargados.repository;

import com.example.voz_animal_proyect.encargados.model.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargadosRepository extends JpaRepository <Encargado, Long> {
}
