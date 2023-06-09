package com.example.voz_animal_proyect.mascotas.service;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;

import java.util.List;

public interface MascotaService {

    List<Mascotas> listarMascotas();

    void guardarMascotas(Mascotas mascotas);

    Mascotas obtenerMascotasPorId(long id);

    void eliminarMascotas (long id);

    List<Mascotas> findByRaza(long id);

    List<Mascotas> obtenerMascotasPorIdLista(long id);



    List<Mascotas> findByRazaAlbergue(long id, long ida);

}
