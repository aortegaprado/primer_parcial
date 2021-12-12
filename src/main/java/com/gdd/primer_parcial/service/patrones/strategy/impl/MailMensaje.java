package com.gdd.primer_parcial.service.patrones.strategy.impl;

import com.gdd.primer_parcial.model.UsuarioPremio;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import com.gdd.primer_parcial.service.util.StrategyName;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailMensaje implements MensajeStrategy {
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


        Email emailOrganizacion = new Email("dalderete@frba.utn.edu.ar");
        String asunto = "PREMIO GANADOR";
        Email emailDelContacto = new Email(usuarios.getEmail());
        Content contenido = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(emailOrganizacion, asunto, emailDelContacto, contenido);

        SendGrid sg = new SendGrid("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"); //token de sendgrid
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Enviando mail");
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.MailMensaje;
    }
}
