package edu.ingsoft.actividad.comportamiento.caso01;

import java.util.List;

public class Pedido {
    private final String id;
    private final String cliente;
    private final List<String> items;
    private final long total;
    private final String cupon;
    private final String nota;
    private final boolean regalo;
    private final String franja;
    private String estado = "CREADO";

    private final Inventario inventario = new Inventario();
    private final Notificador notificador = new Notificador();
    private final Analitica analitica = new Analitica();
    private final RapiEnviosApi transportadora = new RapiEnviosApi();

    public Pedido(String id, String cliente, List<String> items, long total, String cupon,
                  String nota, boolean regalo, String franja) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
        this.cupon = cupon;
        this.nota = nota;
        this.regalo = regalo;
        this.franja = franja;
    }

    public void pagar() {
        switch (estado) {
            case "CREADO" -> {
                estado = "PAGADO";
                inventario.reservar(items);
                notificador.enviar(cliente, "Pago recibido por $" + total);
                analitica.registrar(id + " PAGADO");
            }
            case "CANCELADO" -> System.out.println("  No se puede pagar un pedido cancelado");
            default -> System.out.println("  El pedido ya fue pagado");
        }
    }

    public void despachar() {
        if (estado.equals("PAGADO")) {
            String guia = transportadora.crearGuia("BOGOTA|" + cliente.toUpperCase() + "|"
                    + items.size() * 2);
            estado = "DESPACHADO";
            notificador.enviar(cliente, "Pedido en camino, guía " + guia
                    + (regalo ? " (empaque de regalo)" : ""));
            analitica.registrar(id + " DESPACHADO");
        } else {
            System.out.println("  No se puede despachar en estado " + estado);
        }
    }

    public void entregar() {
        if (estado.equals("DESPACHADO")) {
            estado = "ENTREGADO";
            notificador.enviar(cliente, "Pedido entregado en franja " + franja);
            analitica.registrar(id + " ENTREGADO");
        } else {
            System.out.println("  No se puede entregar en estado " + estado);
        }
    }

    public void cancelar() {
        switch (estado) {
            case "CREADO" -> estado = "CANCELADO";
            case "PAGADO", "DESPACHADO" -> { // DESPACHADO no debería poder cancelarse
                estado = "CANCELADO";
                inventario.liberar(items);
                notificador.enviar(cliente, "Pedido cancelado; se reembolsarán $" + total);
                analitica.registrar(id + " CANCELADO");
            }
            default -> System.out.println("  No se puede cancelar en estado " + estado);
        }
    }

    public String estado() {
        return estado;
    }
}
