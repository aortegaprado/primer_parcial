package com.gdd.primer_parcial.service.patrones.strategy.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;

public class SmsMensaje implements MensajeStrategy {
    @Override
    public String enviarMensaje(Usuarios usuarios) {
        System.out.println("sms");
        return null;
    }
}
