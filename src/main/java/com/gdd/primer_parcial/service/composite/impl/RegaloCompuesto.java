package com.gdd.primer_parcial.service.composite.impl;

import com.gdd.primer_parcial.service.composite.Premio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegaloCompuesto implements Premio {
    private List<Premio> premios = new ArrayList<>();
    private String name;

    public RegaloCompuesto() {
    }

    public RegaloCompuesto(String name) {
        this.name = name;
    }

    @Override
    public List<Premio> getPremios() {
        return this.premios;
    }

    @Override
    public void add(Premio e) {
        if (e != null) {
            this.premios.add(e);
        }
    }

    @Override
    public void remove(Premio e) {
        if (e != null) {
            this.premios.remove(e);
        }
    }

    @Override
    public void mostrarRegaloUnitario() {

        for(Premio e: premios){

            System.out.println(e);
            e.mostrarRegaloUnitario();
        }
    }


    @Override
    public String getName() {
        return this.name;
    }

}

