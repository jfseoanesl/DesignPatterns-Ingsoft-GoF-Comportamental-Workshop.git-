package edu.ingsoft.actividad.comportamiento.caso05;

import java.util.ArrayList;
import java.util.List;

public class RegistroDispositivos {
    private final List<Object> dispositivos = new ArrayList<>();

    public void registrar(Object d) {
        dispositivos.add(d);
    }

    public int total() {
        return dispositivos.size();
    }
}
