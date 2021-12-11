package com.gdd.primer_parcial.service.usuario.impl;

import com.gdd.primer_parcial.dao.UsuariosDAO;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.SorteoUsuarioContexto;
import com.gdd.primer_parcial.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuariosDAO usuariosDAO;
    @Autowired
    private SorteoUsuarioContexto sorteoUsuario;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosDAO.findAll();
    }

    @Override
    public List<Usuarios> getUsuariosByEstado(String estado) {
        return usuariosDAO.getUsuariosByEstado(estado);
    }

    @Override
    public Usuarios getById(Integer id) {
        return usuariosDAO.getById(id);
    }

    @Override
    public void modificaUsuario(Usuarios usuario) {
        usuariosDAO.save(usuario);
    }

    @Override
    public void entregaMensaje() {
        sorteoUsuario.estadoGanadores();
        String estado = sorteoUsuario.accion(null);
        List<Usuarios> usuarios = usuariosDAO.getUsuariosByEstado(estado);
        for (Usuarios usuario : usuarios) {
            /*falta hacer*/
            /*por strategy le entrego el  mensaje por sms o mail*/
            /*fin de stratey que hay que hacer*/
            estado = sorteoUsuario.accion(usuario);
            usuario.setEstado(estado);
            this.modificaUsuario(usuario);
        }

    }
}
