package com.example.voz_animal_proyect.encargados.service;

import com.example.voz_animal_proyect.formularios.model.SolicitudVisita;
import org.springframework.stereotype.Service;


public interface SolicitudService {

    void guardarSolicitud(SolicitudVisita solicitudVisita);
}
