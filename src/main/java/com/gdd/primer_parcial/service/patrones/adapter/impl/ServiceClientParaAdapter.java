package com.gdd.primer_parcial.service.patrones.adapter.impl;

import com.gdd.primer_parcial.model.SmsRequest;
import com.gdd.primer_parcial.service.patrones.adapter.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class ServiceClientParaAdapter {
    private final SmsSender smsSender;

    @Autowired
    public ServiceClientParaAdapter(@Qualifier("twilio") smsSenderAdapterImpl twilioSmsSender) {
        this.smsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){

        smsSender.sendSms(smsRequest);
    }
}
