package com.example.voz_animal_proyect.albergue.controller;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.service.AlbergueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Controller
public class AlbergueController {

    @Autowired
    private AlbergueService albergueService;


    @GetMapping("/albergues")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaAlbergues",albergueService.listarAlbergue());
        return "albergues/albergues";
    }

    @GetMapping("/nuevoAlbergue")
    public String nuevoAlbergue(Map<String, Object> model){
        Albergue Albergue = new Albergue();
        model.put("albergue", Albergue);
        return  "albergues/nuevoAlbergue";
    }


    @RequestMapping(value = "/guardarAlbergue", method = RequestMethod.POST)
    public String guardarAlbergue(Albergue albergue,@RequestParam("file") MultipartFile foto){
        if(!foto.isEmpty()) {
            Path directorioRecursos = Paths.get("src//main//resources//static/img/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                System.out.println(foto.getOriginalFilename());
                albergue.setFoto(foto.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            albergueService.guardarAlbergue(albergue);
        }
        return "redirect:/albergues";
    }

    @GetMapping("/actualizarAlbergue/{id}")
    public String actualizarAlbergue(@PathVariable(value="id") long id, Map<String, Object>  model){
        Albergue Albergue =  albergueService.obtenerAlberguePorId(id);

        String fotoNombre = Albergue.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            Albergue.setFoto(null);
            albergueService.guardarAlbergue(Albergue);
            model.put("mensaje", "La foto se eliminó correctamente");
        } else {
            model.put("mensaje", "No se pudo eliminar la foto");
        }

        model.put("albergue", Albergue);
        return "albergues/actualizarAlbergue";
    }

    @GetMapping("/eliminarAlbergue/{id}")
    public String eliminarAlbergue(@PathVariable(value="id") long id){
        Albergue Albergue =  albergueService.obtenerAlberguePorId(id);

        String fotoNombre = Albergue.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        // Eliminar el archivo de la foto
        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            // Si se eliminó el archivo, también actualizamos el objeto Albergue
            Albergue.setFoto(null);
            albergueService.guardarAlbergue(Albergue);
        }
        albergueService.eliminarAlbergue(id);
        return "redirect:/albergues";
    }
}
