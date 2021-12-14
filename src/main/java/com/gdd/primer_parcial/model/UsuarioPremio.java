package com.gdd.primer_parcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name="usuario_premio" ,catalog="parcial")
public class UsuarioPremio  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_USUARIO_PREMIO", unique=true, nullable=false)
    private Integer idUsuarioPremio;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO", nullable=false)
    private Usuarios usuarios;

    @Column(name="NOMBRE_PREMIO", nullable=false, length=100)
    private String nombrePremio;

}


