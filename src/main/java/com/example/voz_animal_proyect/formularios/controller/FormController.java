package com.example.voz_animal_proyect.formularios.controller;
import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import org.springframework.http.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.voz_animal_proyect.encargados.model.Encargado;
import com.example.voz_animal_proyect.encargados.service.SolicitudService;
import com.example.voz_animal_proyect.formularios.model.DatosFormulario;
import com.example.voz_animal_proyect.formularios.model.SolicitudVisita;
import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.example.voz_animal_proyect.postulantes.service.PostulanteService;
import com.example.voz_animal_proyect.raza.model.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FormController {
    @Autowired
    private PostulanteService postulanteService;

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/form")
    public String verFormulario(Model model){
        Postulantes postulantes = new Postulantes();
        model.addAttribute("postulante", postulantes);
        return "albergues/form";
    }
    @PostMapping("/guardarForm")
    public String guardarPostulantess(@ModelAttribute("postulante") Postulantes postulantes, Model model) {
        postulanteService.guardarPostulantes(postulantes);
        Postulantes Postulantes =  postulanteService.obtenerPostulantesPorId(postulantes.getId());
        model.addAttribute("postulantes", Postulantes);
        return "albergues/formulario";
    }

    @PostMapping(value = "/solicitud/mascota/{mascotas}/albergue/{albergue}/postulante/{postulantes}/fecha/{date}")
    @ResponseBody
    public SolicitudVisita RazaPorFormulario(@PathVariable(value="mascotas") int mascotas,
                                        @PathVariable(value="albergue") int albergue,
                                        @PathVariable(value="postulantes") int postulantes,
                                        @PathVariable(value="date") String date) {

        SolicitudVisita solicitudVisita = new SolicitudVisita();

        // Crear objetos mascotas, albergue y postulantes según los IDs proporcionados
        Mascotas mascotasObjeto = new Mascotas();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        mascotasObjeto.setId(mascotas);

        Albergue albergueObjeto = new Albergue();
        albergueObjeto.setId(albergue);

        Postulantes postulantesObjeto = new Postulantes();
        postulantesObjeto.setId(postulantes);

        // Establecer los objetos creados en la solicitud
        solicitudVisita.setMascotas(mascotasObjeto);
        solicitudVisita.setAlbergue(albergueObjeto);
        solicitudVisita.setPostulantes(postulantesObjeto);
        try {
            Date fecha = dateFormat.parse(date);
            solicitudVisita.setDate(fecha);
            System.out.println(fecha);
        } catch (ParseException e) {
            // Manejar la excepción si la cadena de texto no tiene el formato esperado
            e.printStackTrace();
        }

        solicitudService.guardarSolicitud(solicitudVisita);

        return solicitudVisita;
    }

    @GetMapping("/inicio")
    public String verInicio(){

        return "albergues/Lobby";
    }
    @GetMapping("/lobbyinicio")
    public String verLobbyInicio(){

        return "albergues/lobbyInicioSesion";
    }
    @GetMapping("/solicitud")
    public String listarSolicitudes(Model model) {
        List<SolicitudVisita> solicitudes = solicitudService.obtenerSolicitudes();
        model.addAttribute("solicitudes", solicitudes);
        return "albergues/solicitud";
    }

}
