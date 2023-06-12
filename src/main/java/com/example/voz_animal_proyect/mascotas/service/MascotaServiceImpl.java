package com.example.voz_animal_proyect.mascotas.service;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.repository.AlbergueRepository;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.repository.MascotaRepository;
import com.example.voz_animal_proyect.raza.model.Raza;
import com.example.voz_animal_proyect.raza.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private AlbergueRepository albergueRepository;

    @Autowired
    private RazaRepository razaRepository;

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

    @Override
    public List<Mascotas> findByRaza(long id) {
        Raza raza = razaRepository.findById(id).orElse(null);
        if (raza != null) {
            List<Mascotas> mascotas = mascotaRepository.findByRaza(raza);

            return mascotas;
        } else {
            throw new InvalidDataAccessApiUsageException("Mensaje de la excepción");        }

    }

    @Override
    public List<Mascotas> findByRazaAlbergue(long id, long ida) {
        Raza raza = razaRepository.findById(id).orElseThrow(() -> new InvalidDataAccessApiUsageException("Mensaje de la excepción"));
        Albergue albergue = albergueRepository.findById(ida).orElseThrow(() -> new InvalidDataAccessApiUsageException("Mensaje de la excepción"));
        return mascotaRepository.findByRazaAndAlbergue(raza, albergue);
    }

    @Override
    public List<Mascotas> obtenerMascotasPorIdLista(long id) {
        Optional<Mascotas> opcional = mascotaRepository.findById(id);
        if (opcional.isPresent()) {
            Mascotas mascotas = opcional.get();
            List<Mascotas> listaMascotas = new ArrayList<>();
            listaMascotas.add(mascotas);
            return listaMascotas;
        } else {
            throw new RuntimeException("Mascota no encontrada para el id: " + id);
        }
    }
}
