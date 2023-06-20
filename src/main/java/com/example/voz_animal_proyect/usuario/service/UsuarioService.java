package com.example.voz_animal_proyect.usuario.service;

import com.example.voz_animal_proyect.usuario.model.Usuario;

public interface UsuarioService {


     String findUsuarioByNombre(String nomUs, String contra);


     Usuario saveUser(Usuario usuario);

}
