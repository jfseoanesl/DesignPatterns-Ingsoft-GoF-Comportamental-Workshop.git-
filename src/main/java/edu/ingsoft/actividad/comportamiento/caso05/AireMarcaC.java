package edu.ingsoft.actividad.comportamiento.caso05;

/** SDK fabricante C (no modificable): temperatura en Fahrenheit. */
public class AireMarcaC {
    public void setFahrenheit(int f) {
        System.out.println("  aire -> " + f + " °F");
    }

    public void apagar() {
        System.out.println("  aire -> apagado");
    }
}
