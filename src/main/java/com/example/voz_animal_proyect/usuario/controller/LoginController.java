package com.example.voz_animal_proyect.usuario.controller;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "auth/frmLogin";
    }
    @GetMapping("/registrar")
    public String registrar() {
        return "auth/frmRegistar";
    }

    @PostMapping("/guardarUsuario")
    public String gaurdarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.saveUser(usuario);
        return "auth/login";
    }
}
