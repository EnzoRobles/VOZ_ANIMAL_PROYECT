package com.example.voz_animal_proyect.mascotas.model;

import com.example.voz_animal_proyect.albergue.model.Albergue;
import com.example.voz_animal_proyect.formularios.model.SolicitudVisita;
import com.example.voz_animal_proyect.raza.model.Raza;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tb_mascotas")
@Getter
@Setter
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private long id;

    @ManyToOne()
    @JoinColumn(name = "id_raza")
    @JsonManagedReference
    private Raza raza;

    @Column(name="descripcion", length = 300 )
    private String descripcion;

    @Column(name="sexo", length = 1 )
    private String sexo;

    @Column(name="peso", length = 300 )
    private String peso;

    @Column(name="foto", length = 300 )
    private String foto;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="edad", length = 9, nullable = false)
    private String edad;

    @Column(name="estado", length = 1, nullable = false)
    private int estado;

    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0: nombreEstado = "Registrado";break;
            case 1: nombreEstado = "Activo";break;
            default: nombreEstado = "Inactivo";
        }
        return nombreEstado;
    }
    public String NombreSexo() {
        String nombreSexo = null;
        switch (sexo) {
            case "M": nombreSexo = "Macho";break;
            case "H": nombreSexo = "Hembra";
        }
        return nombreSexo;
    }

    @ManyToOne()
    @JoinColumn(name = "id_albergue")
    @JsonManagedReference
    private Albergue albergue;

    @OneToMany(mappedBy = "mascotas")
    @JsonIgnore
    private Set<SolicitudVisita> solicitudes;
}
