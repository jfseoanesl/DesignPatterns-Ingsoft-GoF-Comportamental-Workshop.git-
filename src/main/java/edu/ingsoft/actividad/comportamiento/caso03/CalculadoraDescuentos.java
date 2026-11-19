package edu.ingsoft.actividad.comportamiento.caso03;

import java.time.LocalDate;
import java.util.Set;

/** Calcula el descuento de UNA línea de configuración sobre un carrito. */
public class CalculadoraDescuentos {
    private static final LocalDate FIN_VIGENCIA = LocalDate.of(2026, 11, 30);
    private static final Set<String> SEDES = Set.of("BOG-01", "MED-03", "CAL-02");
    private final long topeDiario = 50_000;
    private long usadoHoy = 0;

    public long aplicar(String lineaConfig, Carrito carrito, Cliente cliente, String sede,
                        LocalDate hoy) {
        String[] p = lineaConfig.split(";");
        String tipo = p[0];
        if (cliente.bloqueado()) {
            return 0;
        }
        if (hoy.isAfter(FIN_VIGENCIA)) {
            return 0;
        }
        long descuento = 0;
        if (tipo.equals("PORCENTAJE")) {
            if (!SEDES.contains(sede)) {
                return 0;
            }
            int pct = Integer.parseInt(p[2]);
            for (Item i : carrito.items) {
                if (i.categoria().equals(p[1])) {
                    descuento += i.precio() * i.cantidad() * pct / 100;
                }
            }
            if (usadoHoy + descuento > topeDiario) {
                descuento = topeDiario - usadoHoy;
            }
        } else if (tipo.equals("LLEVE_PAGUE")) {
            int lleve = Integer.parseInt(p[2]);
            int pague = Integer.parseInt(p[3]);
            for (Item i : carrito.items) {
                if (i.producto().equals(p[1])) {
                    descuento += (long) (i.cantidad() / lleve) * (lleve - pague) * i.precio();
                }
            }
            if (usadoHoy + descuento > topeDiario) {
                descuento = topeDiario - usadoHoy;
            }
        } else if (tipo.equals("POR_MONTO")) {
            long minimo = Long.parseLong(p[1]);
            if (carrito.total() >= minimo) {
                descuento = Long.parseLong(p[2]); // aquí se olvidó el tope diario
            }
        } else if (tipo.equals("AFILIADO")) {
            if (cliente.afiliado()) {
                descuento = carrito.total() * Integer.parseInt(p[1]) / 100;
            }
        }
        usadoHoy += descuento;
        return descuento;
    }
}
