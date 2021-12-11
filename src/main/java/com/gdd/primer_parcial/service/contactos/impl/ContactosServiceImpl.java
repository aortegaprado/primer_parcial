package com.gdd.primer_parcial.service.contactos.impl;

import com.gdd.primer_parcial.dao.ContactosDAO;
import com.gdd.primer_parcial.dao.UsuariosDAO;
import com.gdd.primer_parcial.model.Contactos;
import com.gdd.primer_parcial.service.contactos.ContactosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactosServiceImpl implements ContactosService {
    @Autowired
    ContactosDAO contactosDAO;
    @Override
    public List<Contactos> getAllContactos() {
        return contactosDAO.findAll();
    }

    @Override
    public Contactos getContactosById(Integer idContactos) {
        return contactosDAO.getById(idContactos);
    }
}
