package com.gdd.primer_parcial.service.StateMachin.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.StateMachin.EstadoUsuario;
import com.gdd.primer_parcial.service.util.EstadosEnum;

public class Participa implements EstadoUsuario {


    @Override
    public String accion(Usuarios usuario) {

        return EstadosEnum.PARTICIPANTE.name();
    }


}
