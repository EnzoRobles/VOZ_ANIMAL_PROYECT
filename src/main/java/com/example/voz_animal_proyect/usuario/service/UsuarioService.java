package com.example.voz_animal_proyect.usuario.service;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public Usuario findUsuarioByNombre(String usn){
        return usuarioRepository.findByUserName(usn);
    }

    public Usuario saveUser(Usuario usuario){
    usuario.setContra(bCryptPasswordEncoder.encode(usuario.getContra()));
    return usuarioRepository.save(usuario);
    }
}
