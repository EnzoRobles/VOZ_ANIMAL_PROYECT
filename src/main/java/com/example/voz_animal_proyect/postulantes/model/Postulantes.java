package com.example.voz_animal_proyect.postulantes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_postulantes")
@Getter
@Setter
/*idpostulante,nombres,apellidos,telefono,dni,foto,direccion,puntaje*/
public class Postulantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_postulante")
    private long id;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="apellido", length = 100, nullable = false)
    private String apellido;

    @Column(name="telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name="dni", length = 8, nullable = false)
    private String dni;

    @Column(name="foto", length = 300 )
    private String foto;

    @Column(name="direccion", length = 300, nullable = false )
    private String direccion;

    @Column(name="puntaje", length = 9, nullable = false)
    private String puntaje;


}
