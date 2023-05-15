package com.example.voz_animal_proyect.postulantes.service;

import com.example.voz_animal_proyect.postulantes.model.Postulantes;

import java.util.List;

public interface PostulanteService {

    List<Postulantes> listarPostulantes();

    void guardarPostulantes(Postulantes postulantes);

    Postulantes obtenerPostulantesPorId(long id);

    void eliminarPostulantes (long id);

}
