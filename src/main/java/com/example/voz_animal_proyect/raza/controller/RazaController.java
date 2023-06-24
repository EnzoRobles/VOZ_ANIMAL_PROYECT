package com.example.voz_animal_proyect.raza.controller;


import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.example.voz_animal_proyect.postulantes.service.PostulanteService;
import com.example.voz_animal_proyect.raza.model.Raza;
import com.example.voz_animal_proyect.raza.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class RazaController {

    @Autowired
    private RazaService razaService;

    @GetMapping("/razas")
    public String PaginaInicio(Model model){
        model.addAttribute("listarRaza",razaService.listarRaza());
        return "albergues/razas";
    }

    @GetMapping("/nuevoRaza")
    public String nuevoRaza(Model model){
        Raza raza = new Raza();
        model.addAttribute("raza",raza);
        return "albergues/nuevoRaza";
    }

    @PostMapping("/guardarRaza")
    public String guardarRaza(@ModelAttribute("razas") Raza raza){
        razaService.guardarRaza(raza);
        return "redirect:/razas";
    }

    /*
    @Autowired
    private PostulanteService postulanteService;

    @GetMapping("/razas")
    public String PaginaInicio(Model model){
        model.addAttribute("listarRaza",razaService.listarRaza());
        return "albergues/razas";
    }

    @GetMapping("/nuevoRaza")
    public String nuevoRaza(Model model){
        Raza raza = new Raza();
        model.addAttribute("razas",raza);
        return "albergues/nuevoRaza";
    }

    @GetMapping("/guardarRaza")
    public String guardarRaza(@ModelAttribute("razas") Raza raza){
        razaService.guardarRaza(raza);
        return "redirect:/razas";
    }



    @PostMapping(value = "/form/{tamano}/{horas}/{personalidad}/{habilidad}/{vivienda}/{hogar}")
    @ResponseBody
    public List<Raza> RazaPorFormulario(@PathVariable(value="tamano") int tamano,
                                        @PathVariable(value="horas") int horas,
                                        @PathVariable(value="personalidad") String personalidad,
                                        @PathVariable(value="habilidad") String habilidad,
                                        @PathVariable(value="vivienda") int vivienda,
                                        @PathVariable(value="hogar") int hogar) {

        return razaService.findByTamanoAndHorasAndPersonalidadAndHabilidadAndViviendaAndHogar(tamano, horas, personalidad, habilidad, vivienda, hogar);
    }*/
}
