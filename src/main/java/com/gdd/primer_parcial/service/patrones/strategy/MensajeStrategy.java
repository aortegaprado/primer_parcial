package com.gdd.primer_parcial.service.patrones.strategy;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.util.StrategyName;

public interface MensajeStrategy {
    String enviarMensaje(Usuarios usuarios);

    StrategyName getStrategyName();
}
