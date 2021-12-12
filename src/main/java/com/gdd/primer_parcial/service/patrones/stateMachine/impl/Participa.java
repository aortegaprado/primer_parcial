package com.gdd.primer_parcial.service.patrones.stateMachine.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.EstadoUsuario;
import com.gdd.primer_parcial.service.util.EstadosEnum;
import org.springframework.stereotype.Component;

@Component
public class Participa implements EstadoUsuario {


    @Override
    public String accion(Usuarios usuario) {

        return EstadosEnum.PARTICIPANTE.name();
    }


}
