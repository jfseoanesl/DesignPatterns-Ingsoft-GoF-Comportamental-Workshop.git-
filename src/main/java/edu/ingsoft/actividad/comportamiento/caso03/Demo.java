package edu.ingsoft.actividad.comportamiento.caso03;

import java.time.LocalDate;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito(List.of(
                new Item("Leche", "LACTEOS", 4_200, 6),
                new Item("Yogur", "LACTEOS", 3_500, 4),
                new Item("GASEOSA", "BEBIDAS", 6_000, 7),
                new Item("Arroz", "GRANOS", 5_800, 3)));
        Cliente ana = new Cliente("Ana", true, false);
        LocalDate hoy = LocalDate.of(2026, 11, 17);
        String[] config = {"PORCENTAJE;LACTEOS;15", "LLEVE_PAGUE;GASEOSA;3;2",
                           "POR_MONTO;80000;40000", "AFILIADO;5"};

        CalculadoraDescuentos calc = new CalculadoraDescuentos();
        System.out.printf("Total carrito: $%,d%n", carrito.total());
        long total = 0;
        for (String linea : config) {
            long d = calc.aplicar(linea, carrito, ana, "BOG-01", hoy);
            total += d;
            System.out.printf("%-26s -> $%,d%n", linea, d);
        }
        System.out.printf("Descuento total: $%,d (tope diario $50,000)%n", total);
    }
}
