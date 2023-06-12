package com.example.voz_animal_proyect.raza.service;

import com.example.voz_animal_proyect.raza.model.Raza;
import com.example.voz_animal_proyect.raza.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazaServiceImpl implements RazaService{

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public List<Raza> listarRaza() {
        return razaRepository.findAll();
    }

    @Override
    public void guardarRaza(Raza raza) {
        razaRepository.save(raza);
    }

    @Override
    public Raza obtenerRazaPorId(long id) {
        Optional<Raza> opcional = razaRepository.findById(id);
        Raza raza;
        if(opcional.isPresent()){
            raza= opcional.get();
        }else{
            throw new RuntimeException("Raza no encontrado para el id: "+id);
        }
        return raza;    }

    @Override
    public void eliminarRaza(long id) {
        razaRepository.deleteById(id);
    }

    @Override
    public List<Raza> findByTamanoAndHorasAndPersonalidadAndHabilidadAndViviendaAndHogar(int tamano, int horas, String personalidad, String habilidad, int vivienda, int hogar) {
        return razaRepository.findByTamanoLessThanEqualAndHorasLessThanEqualAndPersonalidadAndHabilidadAndViviendaLessThanEqualAndHogarLessThanEqual(tamano, horas, personalidad, habilidad, vivienda, hogar);
    }
}
