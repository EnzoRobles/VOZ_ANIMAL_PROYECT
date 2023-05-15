package com.example.voz_animal_proyect.encargados.controller;


import com.example.voz_animal_proyect.encargados.model.Encargado;
import com.example.voz_animal_proyect.encargados.service.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncargadosController {

    @Autowired
    private EncargadoService encargadoService;

    @GetMapping("/encargado")
    public String PaginaInicio(Model model){
        model.addAttribute("listaEncargados",encargadoService.listarEncargados());
        return "albergues/encargado";
    }

    @GetMapping("/nuevoEncargado")
    public String nuevoEncargado(Model model){
        Encargado encargado = new Encargado();
        model.addAttribute("encargado", encargado);
        return "albergues/nuevoEncargado";
    }

    @PostMapping("/guardarEncargado")
    public String guardarEncargdo(@ModelAttribute("encargado") Encargado encargado) {
        encargadoService.guardarEncargos(encargado);
        return "redirect:/encargado";
    }
    @GetMapping("/actualizarEncargados/{id}")
    public String actualizarEncargado(@PathVariable(value = "id") long id, Model model){
        Encargado encargado = encargadoService.obtenerEncargados(id);
        model.addAttribute("encargado", encargado);
        return  "albergues/actualizarEncargados";
    }
    @GetMapping("/eliminarEncargados/{id}")
    public String eliminarEncargado(@PathVariable(value = "id") long id){
        encargadoService.eliminarEncargados(id);
        return "redirect:/encargado";
    }
}
