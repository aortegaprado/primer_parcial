package com.gdd.primer_parcial.service.patrones.strategy.impl;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

public class MailMensaje implements MensajeStrategy {
    @Override
    public String enviarMensaje(Usuarios usuarios) {
        System.out.println("mail");
        return null;
    }
}
