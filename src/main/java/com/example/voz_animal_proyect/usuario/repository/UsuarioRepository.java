package com.example.voz_animal_proyect.usuario.repository;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsnUsAndContra(String nomUs, String contra );

}
