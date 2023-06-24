package com.example.voz_animal_proyect.usuario.service;

import com.example.voz_animal_proyect.usuario.model.Usuario;

import java.util.List;

public interface UsuarioService {


     String findUsuarioByNombre(String nomUs, String contra);

     Usuario obtenerUsuarioPorId(long id);

     Usuario saveUser(Usuario usuario);

    List<Usuario> listarUsuario();

    void eliminarUsuario(long id);

}
