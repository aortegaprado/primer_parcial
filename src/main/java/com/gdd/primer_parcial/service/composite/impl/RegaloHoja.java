package com.gdd.primer_parcial.service.composite.impl;

import com.gdd.primer_parcial.service.composite.Premio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegaloHoja implements Premio {

    private String name;

    public RegaloHoja() {
    }

    public RegaloHoja(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Premio e) {
        // nothing to implement
    }

    @Override
    public void remove(Premio e) {
        // nothing to implement
    }

    @Override
    public List<Premio> getPremios() {
        // nothing to implement
        return null;
    }


    @Override
    public void mostrarRegaloUnitario() {

    }



    @Override
    public String toString() {
        return "I am " + getName() + ", Developer";
    }

}