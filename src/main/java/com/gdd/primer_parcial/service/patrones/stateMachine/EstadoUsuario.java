package com.gdd.primer_parcial.service.patrones.stateMachine;


import com.gdd.primer_parcial.model.Usuarios;

public interface EstadoUsuario {
    public String accion(Usuarios usuario);
}
