package com.example.voz_animal_proyect.albergue.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="tb_albergue")
@Getter
@Setter
public class Albergue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_albergue")
    private long id;

    @Column(name="direccion", length = 200, nullable = false)
    private String direccion;

    @Column(name="foto", length = 300 )
    private String foto;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="telefono", length = 9, nullable = false)
    private String telefono;

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

}
