package com.gdd.primer_parcial.configuraciones;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioIniciador {
private final static Logger LOGGER = LoggerFactory.getLogger(TwilioIniciador.class);
    private final TwilioConfiguracion twilioConfiguracion;

    @Autowired
    public TwilioIniciador(TwilioConfiguracion twilioConfiguracion) {
        this.twilioConfiguracion = twilioConfiguracion;
        Twilio.init(
                twilioConfiguracion.getAccountSid(),
                twilioConfiguracion.getAuthToken()
        );
        LOGGER.info("Twilio Inicializado {}", twilioConfiguracion.getAccountSid());
    }
}
