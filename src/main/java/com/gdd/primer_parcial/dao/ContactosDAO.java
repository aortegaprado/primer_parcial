package com.gdd.primer_parcial.dao;

import com.gdd.primer_parcial.model.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactosDAO extends JpaRepository<Contactos,Integer> {
}
