package com.gdd.primer_parcial.service.patrones.strategy.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import com.gdd.primer_parcial.service.twilio.impl.ServiceClientParaAdapter;
import com.gdd.primer_parcial.service.util.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class MailMensaje implements MensajeStrategy {
    @Override
    public String enviarMensaje(Usuarios usuarios) {
        System.out.println("mail");
        return null;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.MailMensaje;
    }
}
