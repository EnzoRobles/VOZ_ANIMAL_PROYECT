package com.example.voz_animal_proyect.raza.service;


import com.example.voz_animal_proyect.raza.model.Raza;

import java.util.List;

public interface RazaService {

    List<Raza> listarRaza();
    void guardarRaza(Raza raza);
    Raza obtenerRaza(long id);
    /*List<Raza> findByTamanoAndHorasAndPersonalidadAndHabilidadAndViviendaAndHogar(int tamano, int horas, String personalidad, String habilidad, int vivienda, int hogar);
    */
}
