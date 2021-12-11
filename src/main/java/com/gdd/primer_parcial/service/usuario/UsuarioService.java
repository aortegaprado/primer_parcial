package com.gdd.primer_parcial.service.usuario;

import com.gdd.primer_parcial.model.Usuarios;

import java.util.List;

public interface UsuarioService {

    List<Usuarios> getAllUsuarios();

    List<Usuarios> getUsuariosByEstado(String estado);

    Usuarios getById(Integer id);

    void modificaUsuario(Usuarios usuario);

    void entregaMensaje();
}
