package com.example.voz_animal_proyect.encargados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "tb_encargado")
public class Encargado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEncargado")
    public long idEncargado;
    @Column(name = "nombre")
    public String nomEn;
    @Column(name = "apellido")
    public String apeEn;
    @Column(name = "telefono")
    public String tel;
    @Column(name = "DNI")
    public int Dni;
    @Column(name = "Estado", length = 1, nullable = false)
    public  int estado;



    public String EstadoEncargado(){
        String estadoEncargado = null;
        switch (estado) {
            case 0 : estadoEncargado = "Registrado";break;
            case 1 : estadoEncargado = "Activo";break;
            default: estadoEncargado = "Inactivo";
        }
        return estadoEncargado;
    }
}
