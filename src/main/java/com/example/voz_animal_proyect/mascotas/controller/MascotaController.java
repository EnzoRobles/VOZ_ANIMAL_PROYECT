package com.example.voz_animal_proyect.mascotas.controller;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.mascotas.service.MascotaService;
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
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;


    @GetMapping("/mascotas")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaMascotas",mascotaService.listarMascotas());
        return "albergues/mascotas";
    }

    @GetMapping("/nuevoMascotas")
    public String nuevoMascotas(Map<String, Object> model){
        Mascotas Mascotas = new Mascotas();
        model.put("mascotas", Mascotas);
        return  "albergues/nuevoMascotas";
    }


    @RequestMapping(value = "/guardarMascotas", method = RequestMethod.POST)
    public String guardarMascotas(Mascotas mascotas,@RequestParam("file") MultipartFile foto){
        if(!foto.isEmpty()) {
            Path directorioRecursos = Paths.get("src//main//resources//static/img/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                System.out.println(foto.getOriginalFilename());
                mascotas.setFoto(foto.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mascotaService.guardarMascotas(mascotas);
        }
        return "redirect:/mascotas";
    }

    @GetMapping("/actualizarMascotas/{id}")
    public String actualizarMascotas(@PathVariable(value="id") long id, Map<String, Object>  model){
        Mascotas Mascotas =  mascotaService.obtenerMascotasPorId(id);

        String fotoNombre = Mascotas.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            Mascotas.setFoto(null);
            mascotaService.guardarMascotas(Mascotas);
            model.put("mensaje", "La foto se eliminó correctamente");
        } else {
            model.put("mensaje", "No se pudo eliminar la foto");
        }

        model.put("mascotas", Mascotas);
        return "albergues/actualizarMascotas";
    }

    @GetMapping("/eliminarMascotas/{id}")
    public String eliminarMascotas(@PathVariable(value="id") long id){
        //en caso no cargue las fotos anotar esto asta aca
       /* Mascotas Mascotas =  mascotaService.obtenerMascotasPorId(id);

        String fotoNombre = Mascotas.getFoto();
        String fotoRuta = "src/main/resources/static/img/uploads/" + fotoNombre;

        // Eliminar el archivo de la foto
        File fotoArchivo = new File(fotoRuta);
        if (fotoArchivo.delete()) {
            // Si se eliminó el archivo, también actualizamos el objeto Albergue
            Mascotas.setFoto(null);
            mascotaService.guardarMascotas(Mascotas);
        }*/
        //hasta aca
        mascotaService.eliminarMascotas(id);
        return "redirect:/mascotas";
    }

}
