package com.gdd.primer_parcial.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name="usuarios",catalog="parcial")
public class Usuarios implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_USUARIO", unique=true, nullable=false)
    private Integer idUsuario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_CONTACTO", nullable=false)
    private Contactos contactos;

    @Column(name="NOMBRE", nullable=false, length=100)
    private String nombre;

    @Column(name="ESTADO", nullable=false, length=20)
    private String estado;

    @Column(name="POSICION_PREMIO")
    private Integer posicionPremio;

    @Column(name="CANT_INTENTOS", nullable=false)
    private Integer cantIntentos;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
    private List<UsuarioPremio> usuarioPremios;


}

