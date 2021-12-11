package com.gdd.primer_parcial.service.patrones.stateMachine.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.EstadoUsuario;
import com.gdd.primer_parcial.service.util.EstadosEnum;

public class Perdedor implements EstadoUsuario {
    @Override
    public String accion(Usuarios usuario) {
        String estado = null;
        if (usuario == null) {
                estado = EstadosEnum.PERDEDOR.name();
        }else{
            if (usuario.getCantIntentos() < 3) {
                estado = EstadosEnum.PERDEDOR.name();
            } else {

                estado = EstadosEnum.PARTICIPANTE.name();
            }

        }
        return estado;
    }
}
