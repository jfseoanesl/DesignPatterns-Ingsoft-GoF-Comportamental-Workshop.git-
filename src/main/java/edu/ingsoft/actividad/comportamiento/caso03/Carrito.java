package edu.ingsoft.actividad.comportamiento.caso03;

import java.util.List;

public class Carrito {
    public final List<Item> items;

    public Carrito(List<Item> items) {
        this.items = items;
    }

    public long total() {
        return items.stream().mapToLong(i -> i.precio() * i.cantidad()).sum();
    }
}
