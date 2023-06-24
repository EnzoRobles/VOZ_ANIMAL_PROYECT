package com.example.voz_animal_proyect.usuario.service;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario obtenerUsuarioPorId(long id){
        Optional<Usuario> opcional =  usuarioRepository.findById(id);
        Usuario usuario;
        if(opcional.isPresent()){
            usuario= opcional.get();
        }else{
            throw new RuntimeException("Usuario no encontrado para el id: "+id);
        }
        return usuario;
    }

    @Override
    public String  findUsuarioByNombre(String nomUs, String contra){


        Usuario obj = usuarioRepository.findByUsnUsAndContra(nomUs, contra);
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

    @Override
    public  List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(long id){
        usuarioRepository.deleteById(id);
    }






}
