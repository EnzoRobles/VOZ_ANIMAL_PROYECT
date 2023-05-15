package com.example.voz_animal_proyect.encargados.service;


import com.example.voz_animal_proyect.encargados.model.Encargado;
import com.example.voz_animal_proyect.encargados.repository.EncargadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EncargadoServiceImp implements EncargadoService{


    @Autowired
    private EncargadosRepository encargadosRepository;

    @Override
    public List<Encargado> listarEncargados() {
        return encargadosRepository.findAll();
    }

    @Override
    public void guardarEncargos(Encargado encargado) {
        encargadosRepository.save(encargado);
    }

    @Override
    public Encargado obtenerEncargados(long id) {
        Optional<Encargado> opcional = encargadosRepository.findById(id);
        Encargado encargado;
        if (opcional.isPresent()){
            encargado = opcional.get();
        }else {
            throw new RuntimeException("Encargado no encontrado por el Id"+ id);
        }
        return encargado;
    }

    @Override
    public void eliminarEncargados(long id) {
        encargadosRepository.deleteById(id);
    }
}
