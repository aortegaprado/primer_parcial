package com.gdd.primer_parcial.service.patrones.stateMachine;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.impl.Ganador;
import com.gdd.primer_parcial.service.patrones.stateMachine.impl.Participa;
import com.gdd.primer_parcial.service.patrones.stateMachine.impl.Perdedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SorteoUsuarioContexto {

    private EstadoUsuario estado;


    public SorteoUsuarioContexto() {
        this.estado = new Participa();
    }


    public void estadoPerdedores() {
        this.estado = new Perdedor();
    }


    public void estadoGanadores() {
        this.estado = new Ganador();
    }


    public void estadoAbilitado() {
        this.estado = new Participa();
    }


    public String accion(Usuarios usuario) {
        return this.estado.accion(usuario);
    }
}
