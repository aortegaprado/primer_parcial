package com.gdd.primer_parcial.model;

public class SmsRequest {
    private final String numeroTelefono; //destino
    private final String mensaje;

    public SmsRequest(String numeroTelefono, String mensaje) {
        this.numeroTelefono = numeroTelefono;
        this.mensaje = mensaje;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "numeroTelefono='" + numeroTelefono + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
