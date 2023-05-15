package com.example.voz_animal_proyect.postulantes.service;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.repository.MascotaRepository;
import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.example.voz_animal_proyect.postulantes.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulanteImpl implements PostulanteService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public List<Postulantes> listarPostulantes() {
        return postulanteRepository.findAll();
    }

    @Override
    public void guardarPostulantes(Postulantes postulantes) {
        postulanteRepository.save(postulantes);
    }

    @Override
    public Postulantes obtenerPostulantesPorId(long id) {
        Optional<Postulantes> opcional = postulanteRepository.findById(id);
        Postulantes postulantes;
        if(opcional.isPresent()){
            postulantes= opcional.get();
        }else{
            throw new RuntimeException("Postulante no encontrado para el id: "+id);
        }
        return postulantes;
    }

    @Override
    public void eliminarPostulantes(long id) {
        postulanteRepository.deleteById(id);
    }

}
