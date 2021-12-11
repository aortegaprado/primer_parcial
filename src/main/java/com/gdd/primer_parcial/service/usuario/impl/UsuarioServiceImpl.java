package com.gdd.primer_parcial.service.usuario.impl;

import com.gdd.primer_parcial.dao.UsuariosDAO;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.SorteoUsuarioContexto;
import com.gdd.primer_parcial.service.patrones.strategy.ContextStrategy;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import com.gdd.primer_parcial.service.patrones.strategy.impl.MailMensaje;
import com.gdd.primer_parcial.service.patrones.strategy.impl.SmsMensaje;
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
            /*Strategy*/
            MensajeStrategy mensajeStrategy = getStrategy(usuario.getContactos().getDescripcion());
            if (mensajeStrategy != null) {
                ContextStrategy contextStrategy = new ContextStrategy(mensajeStrategy);
                contextStrategy.executeStrategy(usuario);
                /*fin de strategy*/
                /*State*/
                estado = sorteoUsuario.accion(usuario);
                usuario.setEstado(estado);
                /*fin de State*/
                /*Modifico usuario*/
                this.modificaUsuario(usuario);
            }
        }

    }

    private static MensajeStrategy getStrategy(String descripcion) {
        MensajeStrategy strategy = null;
        if (descripcion.equals("EMAIL")) {
            strategy = new MailMensaje();
        } else if (descripcion.equals("SMS")) {
            strategy = new SmsMensaje();
        }
        return strategy;
    }
}
