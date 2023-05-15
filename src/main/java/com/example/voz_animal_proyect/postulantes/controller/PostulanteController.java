package com.example.voz_animal_proyect.postulantes.controller;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.albergue.service.AlbergueService;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.example.voz_animal_proyect.postulantes.service.PostulanteService;
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
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;


    @GetMapping("/postulantes")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaPostulantes",postulanteService.listarPostulantes());
        return "albergues/postulantes";
    }

    @GetMapping("/nuevoPostulantes")
    public String nuevoPostulantes(Map<String, Object> model){
        Postulantes Postulantes = new Postulantes();
        model.put("postulantes", Postulantes);
        return  "albergues/nuevoPostulantes";
    }

    /*
    @RequestMapping(value = "/guardarPostulantes", method = RequestMethod.POST)
    public String guardarPostulantes(Postulantes postulantes,@RequestParam("file") MultipartFile foto){
        if(!foto.isEmpty()) {
            Path directorioRecursos = Paths.get("src//main//resources//static/img/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                System.out.println(foto.getOriginalFilename());
                postulantes.setFoto(foto.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            postulanteService.guardarPostulantes(postulantes);
        }
        return "redirect:/postulantes";
    }*/

    /*
    @GetMapping("/actualizarPostulantes/{id}")
    public String actualizarPostulantes(@PathVariable(value="id") long id, Map<String, Object>  model){
        Postulantes Postulantes =  postulanteService.obtenerPostulantesPorId(id);

        String fotoNombre = Postulantes.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            Postulantes.setFoto(null);
            postulanteService.guardarPostulantes(Postulantes);
            model.put("mensaje", "La foto se eliminó correctamente");
        } else {
            model.put("mensaje", "No se pudo eliminar la foto");
        }

        model.put("postulantes", Postulantes);
        return "albergues/actualizarPostulantes";
    }*/

    @GetMapping("/eliminarPostulantes/{id}")
    public String eliminarPostulantes(@PathVariable(value="id") long id){
        //en caso no cargue las fotos anotar esto asta aca
       /* Postulantes Postulantes =  postulanteService.obtenerPostulantesPorId(id);

        String fotoNombre = Postulantes.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        // Eliminar el archivo de la foto
        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            // Si se eliminó el archivo, también actualizamos el objeto Albergue
            Postulantes.setFoto(null);
            postulanteService.guardarPostulantes(Postulantes);
        }*/
        //hasta aca
        postulanteService.eliminarPostulantes(id);
        return "redirect:/postulantes";
    }




















}
