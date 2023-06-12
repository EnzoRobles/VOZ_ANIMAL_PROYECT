package com.example.voz_animal_proyect.raza.model;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tb_raza")
@Getter
@Setter
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_raza")
    private long id;

    @Column(name="nombre", length = 200)
    private String nombre;

    @Column(name="tamano", length = 1)
    private int tamano;

    @Column(name="horas", length = 1)
    private int horas;

    @Column(name="personalidad")
    private String personalidad;

    @Column(name="habilidad")
    private String habilidad;

    @Column(name="vivienda")
    private int vivienda;

    @Column(name="hogar")
    private int hogar;

    @OneToMany(mappedBy = "raza")
    @JsonBackReference
    private Set<Mascotas> mascotas;


}
