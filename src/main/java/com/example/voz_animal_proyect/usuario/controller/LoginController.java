package com.example.voz_animal_proyect.usuario.controller;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/login")
    public String login() {
        return "albergues/login";
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
    @PostMapping(value = "/login/{usuario}/{clave}")
    @ResponseBody
    public String ValidacionLogin(@PathVariable(value="usuario") String usuario,
                                        @PathVariable(value="clave") String clave) {

        return usuarioService.findUsuarioByNombre(usuario,clave);
    }





}
