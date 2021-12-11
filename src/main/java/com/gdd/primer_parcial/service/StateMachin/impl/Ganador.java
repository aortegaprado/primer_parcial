package com.gdd.primer_parcial.service.StateMachin.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.StateMachin.EstadoUsuario;
import com.gdd.primer_parcial.service.util.EstadosEnum;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("Ganador")
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