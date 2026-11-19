package edu.ingsoft.actividad.comportamiento.caso01;

import java.util.List;

public class Inventario {
    public void reservar(List<String> items) {
        System.out.println("  [inventario] reserva " + items);
    }

    public void liberar(List<String> items) {
        System.out.println("  [inventario] libera " + items);
    }
}
