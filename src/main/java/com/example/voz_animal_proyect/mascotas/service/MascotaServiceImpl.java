package com.example.voz_animal_proyect.mascotas.service;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascotas> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void guardarMascotas(Mascotas mascotas) {
        mascotaRepository.save(mascotas);
    }

    @Override
    public Mascotas obtenerMascotasPorId(long id) {
        Optional<Mascotas> opcional = mascotaRepository.findById(id);
        Mascotas mascotas;
        if(opcional.isPresent()){
            mascotas= opcional.get();
        }else{
            throw new RuntimeException("Mascota no encontrada para el id: "+id);
        }
        return mascotas;
    }

    @Override
    public void eliminarMascotas(long id) {
        mascotaRepository.deleteById(id);
    }
}
