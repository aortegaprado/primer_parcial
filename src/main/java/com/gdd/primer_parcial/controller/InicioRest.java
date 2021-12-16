package com.gdd.primer_parcial.controller;

import com.gdd.primer_parcial.service.patrones.composite.Premio;
import com.gdd.primer_parcial.service.patrones.composite.impl.RegaloCompuesto;
import com.gdd.primer_parcial.service.usuario.SorteosService;
import com.gdd.primer_parcial.service.usuario.UsuarioService;
import com.gdd.primer_parcial.service.util.composite.SetPremiosComposite;
import dto.UsuariosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/inicio")
public class InicioRest {


    @Autowired
    private SorteosService sorteosService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private SetPremiosComposite setPremiosComposite;

    @RequestMapping(value = "/sorteo", method = RequestMethod.GET)
    public ResponseEntity<?> sorteoDePremios() {
        ResponseEntity<?> response;

        /*setea premios*/
        /*primera hoja*/
        Premio premio = new RegaloCompuesto("premios");
        /*nodo primerPremio*/
        Premio premio1 = new RegaloCompuesto("premio1");
        /*nodo premioSegundoPremio*/
        Premio premio2 = new RegaloCompuesto("premio2");
        /*nodo premioTercerPremio*/
        Premio premio3 = new RegaloCompuesto("premio3");
        //aca seteo los premios por nodos
        setPremiosComposite.setearArbolComposite(premio, premio1, premio2, premio3);

        /*sortear premios usuarios con estado Participar*/
        List<UsuariosDTO> usuarios= sorteosService.sorteoDePremios(premio, premio1, premio2, premio3);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"description\":\"No se puedo realizar el sorteo\"}");
        }

        return ResponseEntity.ok(usuarios);

    }

    @RequestMapping(value = "/entregaMensage", method = RequestMethod.GET)
    public ResponseEntity<?> entregaMensage() {
        ResponseEntity<?> response;

        /*entrega de mensaje a los ganadores*/

        usuarioService.entregaMensaje();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"description\":\"LA información le llegara a su contacto, Gracias.\"}");

    }


}
