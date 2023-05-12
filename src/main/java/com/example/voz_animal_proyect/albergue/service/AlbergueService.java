package com.example.voz_animal_proyect.albergue.service;

import com.example.voz_animal_proyect.albergue.model.Albergue;

import java.util.List;

public interface AlbergueService {

    List<Albergue> listarAlbergue();

    void guardarAlbergue(Albergue albergue);

    Albergue obtenerAlberguePorId(long id);

    void eliminarAlbergue (long id);

}
