package com.gdd.primer_parcial.service.contactos;

import com.gdd.primer_parcial.model.Contactos;

import java.util.List;

public interface ContactosService {

    List<Contactos> getAllContactos();

    Contactos getContactosById(Integer idContactos);
}
