package com.gdd.primer_parcial.service.usuario.impl;

import com.gdd.primer_parcial.model.UsuarioPremio;
import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.patrones.stateMachine.SorteoUsuarioContexto;
import com.gdd.primer_parcial.service.patrones.composite.Premio;
import com.gdd.primer_parcial.service.usuario.SorteosService;
import com.gdd.primer_parcial.service.usuario.UsuarioService;
import com.gdd.primer_parcial.service.usuarioPremios.UsuarioPremiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class SorteosServiceImpl implements SorteosService {

    @Autowired
    private SorteoUsuarioContexto sorteoUsuario;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    UsuarioPremiosService usuarioPremiosService;

    @Override
    public void sorteoDePremios(Premio premio, Premio premio1, Premio premio2, Premio premio3) {

        //maquina de estados -- en este caso traigo el estado para la busqueda
        sorteoUsuario.estadoAbilitado();
        String estado = sorteoUsuario.accion(null);
        List<Usuarios> usuariosParticipantes = usuarioService.getUsuariosByEstado(estado);
        //Realizo el sorteo
        randomSinRepeticion(usuariosParticipantes, premio1, premio2, premio3);


    }

    private void randomSinRepeticion(List<Usuarios> usuariosParticipantes, Premio premio1, Premio premio2, Premio premio3) {
        Random rand = new Random();
        int numberOfElements = 3;
        //TraerEl podible estado que puedo setear al usuario de la maquina de estados
        sorteoUsuario.estadoGanadores();
        String estado = sorteoUsuario.accion(null);
        /*sorteo de los 3 mejores - ganadores*/
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(usuariosParticipantes.size());
            Usuarios usuario = usuariosParticipantes.get(randomIndex);
            usuario.setEstado(estado);
            if (i == 0) {
                /*primer premio*/
                entregaPremiosAGanador(premio1, usuario);
                /*cambia de estado PArticipante a estado Ganador*/
                usuario.setPosicionPremio(1);

            }
            if (i == 1) {
                entregaPremiosAGanador(premio2, usuario);
                usuario.setPosicionPremio(2);
            }
            if (i == 2) {
                entregaPremiosAGanador(premio3, usuario);
                usuario.setPosicionPremio(3);
            }
            //modifica usuario seteando estado y posicion de premio
            usuarioService.modificaUsuario(usuario);
            //elimina de la lista para que no se repita
            usuariosParticipantes.remove(randomIndex);
        }

        /*perdedores*/
        //TraerEl podible estado que puedo setear al usuario de la maquina de estados
        sorteoUsuario.estadoPerdedores();
        String estadoPerdedor = sorteoUsuario.accion(null);
        for (int i = 0; i < usuariosParticipantes.size(); i++) {
            Usuarios usuario = usuariosParticipantes.get(i);
            usuario.setEstado(estadoPerdedor);
            usuario.setCantIntentos(usuario.getCantIntentos() + 1);
            usuarioService.modificaUsuario(usuario);
        }
    }

    private void entregaPremiosAGanador(Premio premio, Usuarios usuario) {

        /*aca es donde recorro los nodos de composite para dar de alta en las tablas de premios del usuario
         * pero, creo que no lo estoy usando apropiadamente*/
        List<Premio> listPremios = premio.getPremios();
        for (Premio premios : listPremios) {
            if (premios.getPremios() == null) {
                UsuarioPremio usuarioPremio = new UsuarioPremio();
                usuarioPremio.setUsuarios(usuario);
                usuarioPremio.setNombrePremio(premios.getName());
                usuarioPremiosService.altaPremiosByUsuario(usuarioPremio);
            } else {
                for (Premio premioss : premios.getPremios()) {
                    UsuarioPremio usuarioPremio = new UsuarioPremio();
                    usuarioPremio.setUsuarios(usuario);
                    usuarioPremio.setNombrePremio(premioss.getName());
                    usuarioPremiosService.altaPremiosByUsuario(usuarioPremio);
                }
            }
        }
    }


}
