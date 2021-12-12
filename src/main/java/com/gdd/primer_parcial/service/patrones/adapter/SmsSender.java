package com.gdd.primer_parcial.service.patrones.adapter;

import com.gdd.primer_parcial.model.SmsRequest;

public interface SmsSender {

    void  sendSms(SmsRequest smsRequest);
}
