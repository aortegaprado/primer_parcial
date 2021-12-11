package com.gdd.primer_parcial.service.usuarioPremios;

import com.gdd.primer_parcial.model.UsuarioPremio;
import com.gdd.primer_parcial.model.Usuarios;

import java.util.List;

public interface UsuarioPremiosService {

    List<UsuarioPremio> getAllPremios();

    List<UsuarioPremio> getPremiosByUsuario(Integer idUsuario);

    void altaPremiosByUsuario(UsuarioPremio usuarioPremios);
}
