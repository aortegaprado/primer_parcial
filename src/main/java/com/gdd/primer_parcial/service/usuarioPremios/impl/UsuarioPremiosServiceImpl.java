package com.gdd.primer_parcial.service.usuarioPremios.impl;

import com.gdd.primer_parcial.dao.UsuarioPremioDAO;
import com.gdd.primer_parcial.model.UsuarioPremio;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.usuarioPremios.UsuarioPremiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPremiosServiceImpl implements UsuarioPremiosService {
    @Autowired
    UsuarioPremioDAO usuarioPremioDAO;
    @Override
    public List<UsuarioPremio> getAllPremios() {
        return usuarioPremioDAO.findAll();
    }

    @Override
    public List<UsuarioPremio> getPremiosByUsuario(Integer idUsuario) {
        return usuarioPremioDAO.getByIdUsuario(idUsuario);
    }

    @Override
    public void altaPremiosByUsuario(UsuarioPremio usuarioPremio) {
        usuarioPremioDAO.save(usuarioPremio);
    }
}
