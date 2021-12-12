package com.gdd.primer_parcial.service.patrones.adapter.impl;

import com.gdd.primer_parcial.configuraciones.TwilioConfiguracion;
import com.gdd.primer_parcial.service.patrones.adapter.SmsSender;
import com.gdd.primer_parcial.model.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class smsSenderAdapterImpl implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(smsSenderAdapterImpl.class);
    private final TwilioConfiguracion twilioConfiguracion;

    @Autowired
    public smsSenderAdapterImpl(TwilioConfiguracion twilioConfiguracion) {
        this.twilioConfiguracion = twilioConfiguracion;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {

        PhoneNumber to = new PhoneNumber(smsRequest.getNumeroTelefono());
        PhoneNumber from = new PhoneNumber(twilioConfiguracion.getTrialNumber());
        String message = smsRequest.getMensaje();

        MessageCreator creator=Message.creator(to ,from,message );
        creator.create();
        LOGGER.info("Send sms {}"+ smsRequest);
    }
}
