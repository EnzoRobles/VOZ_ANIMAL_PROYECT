package com.example.voz_animal_proyect.encargados.service;




import com.example.voz_animal_proyect.encargados.model.Encargado;

import java.util.List;

public interface EncargadoService {
    List<Encargado> listarEncargados();
    void guardarEncargos(Encargado encargado);
    Encargado obtenerEncargados(long id);
    void eliminarEncargados (long id);
}
