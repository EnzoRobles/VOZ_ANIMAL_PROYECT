package com.example.voz_animal_proyect.encargados.service;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.repository.AlbergueRepository;
import com.example.voz_animal_proyect.encargados.repository.SolicitudRepository;
import com.example.voz_animal_proyect.formularios.model.SolicitudVisita;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.repository.MascotaRepository;
import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.example.voz_animal_proyect.postulantes.repository.PostulanteRepository;
import com.example.voz_animal_proyect.raza.model.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements  SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private AlbergueRepository albergueRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public void guardarSolicitud(SolicitudVisita solicitudVisita) {
        Mascotas mascotas = mascotaRepository.findById(solicitudVisita.getMascotas().getId()).orElse(null);
        Albergue albergue = albergueRepository.findById(solicitudVisita.getAlbergue().getId()).orElse(null);
        Postulantes postulantes = postulanteRepository.findById(solicitudVisita.getPostulantes().getId()).orElse(null);
        solicitudVisita.setMascotas(mascotas);
        solicitudVisita.setAlbergue(albergue);
        solicitudVisita.setPostulantes(postulantes);
        solicitudRepository.save(solicitudVisita);
    }
    @Override
    public List<SolicitudVisita> obtenerSolicitudes() {
        List<SolicitudVisita> solicitudes = solicitudRepository.findAll();

        for (SolicitudVisita solicitud : solicitudes) {
            Albergue albergue = albergueRepository.findById(solicitud.getAlbergue().getId()).orElse(null);
            Mascotas mascota = mascotaRepository.findById(solicitud.getMascotas().getId()).orElse(null);
            Postulantes postulante = postulanteRepository.findById(solicitud.getPostulantes().getId()).orElse(null);

            if (albergue != null) {
                solicitud.setNombreAlbergue(albergue.getNombre());
            }
            if (mascota != null) {
                solicitud.setNombreMascota(mascota.getNombre());
            }
            if (postulante != null) {
                solicitud.setNombrePostulante(postulante.getNombre());
            }
        }
        return solicitudes;
    }
}
