package com.gdd.primer_parcial.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name="contactos",catalog="parcial")
public class Contactos implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_CONTACTO", unique=true, nullable=false)
    private Integer idContacto;

    @Column(name="DESCRIPCION", nullable=false, length=100)
    private String descripcion;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="contactos")
    private List<Usuarios> usuarioses;




}

