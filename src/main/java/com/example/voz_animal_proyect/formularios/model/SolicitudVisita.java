package com.example.voz_animal_proyect.formularios.model;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.example.voz_animal_proyect.postulantes.model.Postulantes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_solicitud_visita")
@Getter
@Setter
public class SolicitudVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_solicitud")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    @JsonIgnoreProperties("solicitudes")
    private Mascotas mascotas;

    @ManyToOne()
    @JoinColumn(name = "id_albergue")
    @JsonManagedReference
    private Albergue albergue;

    @ManyToOne()
    @JoinColumn(name = "id_postulante")
    @JsonManagedReference
    private Postulantes postulantes;

    @Column(name = "fecha_visita")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

}
