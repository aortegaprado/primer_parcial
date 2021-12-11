package com.gdd.primer_parcial.service.patrones.composite;

import java.util.List;

public interface Premio {
    String getName();

    void add(Premio e);

    void remove(Premio e);

    List<Premio> getPremios();

    void mostrarRegaloUnitario();

}
