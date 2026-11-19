package edu.ingsoft.actividad.comportamiento.caso01;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Pedido p1 = new Pedido("P-001", "ana", List.of("café", "miel"), 54_000, null, null,
                true, "tarde");
        System.out.println("P-001:");
        p1.despachar();
        p1.pagar();
        p1.despachar();
        p1.entregar();
        p1.cancelar();
        System.out.println("  estado final: " + p1.estado());

        Pedido p2 = new Pedido("P-002", "luis", List.of("quinua"), 18_000, "BIENVENIDA", null,
                false, "mañana");
        System.out.println("P-002:");
        p2.pagar();
        p2.despachar();
        p2.cancelar();
        System.out.println("  estado final: " + p2.estado());
    }
}
