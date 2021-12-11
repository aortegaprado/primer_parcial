package com.gdd.primer_parcial.service.StateMachin;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.StateMachin.impl.Ganador;
import com.gdd.primer_parcial.service.StateMachin.impl.Participa;
import com.gdd.primer_parcial.service.StateMachin.impl.Perdedor;
import org.springframework.stereotype.Service;

@Service
public class SorteoUsuario {

    private EstadoUsuario estado;

    public SorteoUsuario() {
        estado = new Participa();
    }

    public void estadoPerdedores() {
        estado = new Perdedor();
    }

    public void estadoGanadores() {
        estado = new Ganador();
    }

    public void estadoAbilitado() {
        estado = new Participa();
    }

    public String accion(Usuarios usuario) {
        return estado.accion(usuario);
    }
}
