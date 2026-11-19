package edu.ingsoft.actividad.comportamiento.caso02;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    public String nombre;
    public List<Object> hijos = new ArrayList<>();

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + hijos;
    }
}
