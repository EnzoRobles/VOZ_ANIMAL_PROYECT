package com.example.voz_animal_proyect.usuario.controller;

import com.example.voz_animal_proyect.usuario.model.Usuario;
import com.example.voz_animal_proyect.usuario.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @PostMapping(value = "/login")
    public String ValidacionLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Model model) {
        String message = usuarioService.findUsuarioByNombre(username, password);
        if (message.equals("Se ha Iniciado Sesión")) {
            // Realizar redireccionamiento exitoso
            return "redirect:/lobbyinicio"; // Cambia "/dashboard" por la ruta deseada después del inicio de sesión exitoso
        } else {
            // Agregar mensaje de error y volver a la vista de login
            model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
            return "albergues/login"; // Cambia "albergues/login" por la ruta de tu vista de login
        }
    }




}
