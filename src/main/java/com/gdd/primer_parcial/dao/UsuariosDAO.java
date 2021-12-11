package com.gdd.primer_parcial.dao;

import com.gdd.primer_parcial.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuarios,Integer> {


    @Query("Select u from Usuarios u where u.estado= :estado")
    List<Usuarios> getUsuariosByEstado(String estado);

}
