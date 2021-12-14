package com.gdd.primer_parcial.service.patrones.strategy.impl;

import com.gdd.primer_parcial.model.SmsRequest;
import com.gdd.primer_parcial.model.UsuarioPremio;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.adapter.ServiceClientParaAdapter;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import com.gdd.primer_parcial.service.util.StrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsMensaje implements MensajeStrategy {


@Autowired
ServiceClientParaAdapter serviceClientParaAdapter;

    @Override
    public String enviarMensaje(Usuarios usuarios) {
        String posicion = "";
        if (usuarios.getPosicionPremio() == 1) {
            posicion = "Primer Lugar";
        } else if (usuarios.getPosicionPremio() == 2) {
            posicion = "Segundo Lugar";
        } else if (usuarios.getPosicionPremio() == 3) {
            posicion = "Tercer Lugar";
        }
        String premios = null;
        for (UsuarioPremio usuarioPremio : usuarios.getUsuarioPremios()) {
            premios = premios + "--" + usuarioPremio.getNombrePremio();
        }
        String mensaje = "Estimado/a " + usuarios.getNombre() + " en el sorteo salio como " + posicion + " y ganó estos premios: " + premios;
        SmsRequest smsRequest = new SmsRequest(usuarios.getTelefono(), mensaje);
        serviceClientParaAdapter.sendSms(smsRequest);
        System.out.println(smsRequest.getNumeroTelefono());
        return null;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.SmsMensaje;
    }
}
