package com.example.voz_animal_proyect.postulantes.repository;

import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulantes,Long>{
}
