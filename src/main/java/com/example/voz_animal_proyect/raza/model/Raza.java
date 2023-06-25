package com.example.voz_animal_proyect.raza.model;

import com.example.voz_animal_proyect.mascotas.model.Mascotas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="tb_raza")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_raza")
    public long idRaza;

    @Column(name="habilidad")
    public String habRa;

    @Column(name="hogar", length = 1, nullable = false)
    public int hogRa;

    @Column(name="horas")
    public int horRa;

    @Column(name="nombre")
    public String nomRa;

    @Column(name="personalidad")
    public String perRa;

    @Column(name="tamano", length = 1, nullable = false)
    public int tamRa;

    @Column(name="vivienda", length = 1, nullable = false)
    public int vivRa;

    public String HogarRaza(){
        String hogarRaza = null;
        switch (hogRa) {
            case 0 : hogarRaza = "Solo";break;
            case 1 : hogarRaza = "En Familia";
        }
        return hogarRaza;
    }

    public String TamanoRaza(){
        String tamanoRaza = null;
        switch (tamRa) {
            case 0 : tamanoRaza = "Pequeno";break;
            case 1 : tamanoRaza = "Mediano";break;
            case 2 : tamanoRaza = "Grande";
        }
        return tamanoRaza;
    }

    public String ViviendaRaza(){
        String viviendaRaza = null;
        switch (vivRa) {
            case 0 : viviendaRaza = "Casa";break;
            case 1 : viviendaRaza = "Departamento";
        }
        return viviendaRaza;
    }

    /*@OneToMany(mappedBy = "raza")
    @JsonBackReference
    public Set<Mascotas> mascotas;*/


}
