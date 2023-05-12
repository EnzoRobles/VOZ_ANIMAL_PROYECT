package com.example.voz_animal_proyect.albergue.service;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.repository.AlbergueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbergueServiceImpl implements AlbergueService{

    @Autowired
    private AlbergueRepository albergueRepository;

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
}
