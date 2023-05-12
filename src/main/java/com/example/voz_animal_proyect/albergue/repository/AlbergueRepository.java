package com.example.voz_animal_proyect.albergue.repository;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbergueRepository extends JpaRepository<Albergue,Long> {

}
