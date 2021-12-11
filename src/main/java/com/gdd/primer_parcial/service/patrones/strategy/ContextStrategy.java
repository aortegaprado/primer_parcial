package com.gdd.primer_parcial.service.patrones.strategy;

import com.gdd.primer_parcial.model.Usuarios;

public class ContextStrategy {

    private MensajeStrategy mensajeStrategy;

    public ContextStrategy(MensajeStrategy commissionStrategy){
        this.mensajeStrategy = commissionStrategy;
    }

    public String executeStrategy(Usuarios usuarios){
        return mensajeStrategy.enviarMensaje(usuarios);
    }
}
