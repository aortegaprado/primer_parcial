package com.gdd.primer_parcial.dao;

import com.gdd.primer_parcial.model.Contactos;
import com.gdd.primer_parcial.model.UsuarioPremio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPremioDAO extends JpaRepository<UsuarioPremio, Integer> {


    @Query("select up from UsuarioPremio up where up.usuarios.idUsuario= :idUsuario")
    List<UsuarioPremio> getByIdUsuario(Integer idUsuario);
}