package com.example.voz_animal_proyect.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idUsuario;
    @Column(name = "us_usnom")
    public String usnUs;
    @Column(name = "us_email")
    public String email;
    @Column(name = "us_pass")
    public String contra;
    @Column(name = "us_nombre")
    public String nomUs;
    @Column(name = "us_ape")
    public String apeUs;
}
