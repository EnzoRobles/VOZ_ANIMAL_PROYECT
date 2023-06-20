package com.example.voz_animal_proyect.usuario.service;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;




    @Override
    public String  findUsuarioByNombre(String nomUs, String contra){


        Usuario obj = usuarioRepository.findByNomUsAndContra(nomUs, contra);
        if(obj!= null){
            return  "Se ha Iniciado Sesión";
        }else{
            return  "No se ha Iniciado Sesión";
        }

    }

    @Override
    public Usuario saveUser(Usuario usuario){
    //usuario.setContra(bCryptPasswordEncoder.encode(usuario.getContra()));
    return usuarioRepository.save(usuario);
    }









}
