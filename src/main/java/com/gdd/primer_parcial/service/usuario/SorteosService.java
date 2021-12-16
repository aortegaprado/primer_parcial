package com.gdd.primer_parcial.service.usuario;

import com.gdd.primer_parcial.service.patrones.composite.Premio;
import dto.UsuariosDTO;

import java.util.List;

public interface SorteosService {

    List<UsuariosDTO> sorteoDePremios(Premio premio, Premio premio1, Premio premio2, Premio premio3);
}
