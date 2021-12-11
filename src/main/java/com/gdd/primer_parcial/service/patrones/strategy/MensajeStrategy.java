package com.gdd.primer_parcial.service.patrones.strategy;

import com.gdd.primer_parcial.model.Usuarios;

public interface MensajeStrategy {
    String enviarMensaje(Usuarios usuarios);
}
