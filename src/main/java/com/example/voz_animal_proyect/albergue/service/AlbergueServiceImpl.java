package com.example.voz_animal_proyect.albergue.service;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.repository.AlbergueRepository;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.repository.MascotaRepository;
import com.example.voz_animal_proyect.raza.model.Raza;
import com.example.voz_animal_proyect.raza.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlbergueServiceImpl implements AlbergueService{

    @Autowired
    private AlbergueRepository albergueRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public List<Albergue> listarAlbergue() {
        return albergueRepository.findAll();
    }

    @Override
    public void guardarAlbergue(Albergue albergue) {
        albergueRepository.save(albergue);
    }

    @Override
    public Albergue obtenerAlberguePorId(long id) {
        Optional<Albergue> opcional = albergueRepository.findById(id);
        Albergue albergue;
        if(opcional.isPresent()){
            albergue= opcional.get();
        }else{
            throw new RuntimeException("Albergue no encontrado para el id: "+id);
        }
        return albergue;
    }

    @Override
    public void eliminarAlbergue(long id) {
        albergueRepository.deleteById(id);
    }

    @Override
    public List<Albergue> findByRaza(long id) {
        Raza raza = razaRepository.findById(id).orElse(null);
        List<Albergue> albergues = new ArrayList<>();
        Set<Long> albergueIds = new HashSet<>();


        if (raza != null) {
            List<Mascotas> mascotas = mascotaRepository.findByRaza(raza);
            for (Mascotas mascota : mascotas) {
                Albergue albergue = mascota.getAlbergue();
                long albergueId = albergue.getId();

                if (!albergueIds.contains(albergueId)) {
                    albergues.add(albergue);
                    albergueIds.add(albergueId);
                }
            }
            return albergues;
        } else {
            throw new InvalidDataAccessApiUsageException("Mensaje de la excepción");        }
    }
}
