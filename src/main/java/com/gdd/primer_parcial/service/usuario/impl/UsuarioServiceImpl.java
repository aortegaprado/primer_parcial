package com.gdd.primer_parcial.service.usuario.impl;

import com.gdd.primer_parcial.dao.UsuariosDAO;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.EstadoUsuarioContexto;
import com.gdd.primer_parcial.service.patrones.strategy.ContextStrategy;
import com.gdd.primer_parcial.service.patrones.strategy.MensajeStrategy;
import com.gdd.primer_parcial.service.patrones.strategy.impl.MailMensaje;
import com.gdd.primer_parcial.service.patrones.strategy.impl.SmsMensaje;
import com.gdd.primer_parcial.service.usuario.UsuarioService;
import com.gdd.primer_parcial.service.util.StrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuariosDAO usuariosDAO;
    @Autowired
    private EstadoUsuarioContexto sorteoUsuario;
    @Autowired
    private ContextStrategy contextStrategy;


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
        //taer un string de estado para la busqueda de usuarios
        sorteoUsuario.estadoGanadores();
        String estado = sorteoUsuario.accion(null);
        //traer usuarios
        List<Usuarios> usuarios = usuariosDAO.getUsuariosByEstado(estado);

        for (Usuarios usuario : usuarios) {

            /*Strategy*/
            MensajeStrategy mensajeStrategy = null;
            if (usuario.getContactos().getDescripcion().equals("EMAIL")) {
                mensajeStrategy = contextStrategy.findStrategy(StrategyName.MailMensaje);
            } else if (usuario.getContactos().getDescripcion().equals("SMS")) {
                mensajeStrategy = contextStrategy.findStrategy(StrategyName.SmsMensaje);
            }

            mensajeStrategy.enviarMensaje(usuario);
            /*fin de strategy*/

            /*State*/
            estado = sorteoUsuario.accion(usuario);
            usuario.setEstado(estado);
            /*fin de State*/
            /*Modifico usuario*/
            this.modificaUsuario(usuario);

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
