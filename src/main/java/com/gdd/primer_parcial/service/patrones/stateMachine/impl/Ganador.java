package com.gdd.primer_parcial.service.patrones.stateMachine.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.EstadoUsuario;
import com.gdd.primer_parcial.service.usuario.UsuarioService;
import com.gdd.primer_parcial.service.util.EstadosEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ganador implements EstadoUsuario {

    @Override
    public String accion(Usuarios usuario) {
        String estado = null;
        if (usuario == null) {
            estado= EstadosEnum.GANADOR.name();
        } else {

            estado=EstadosEnum.PREMIO_NOTIFICADO.name();
        }
        return estado;
    }
}