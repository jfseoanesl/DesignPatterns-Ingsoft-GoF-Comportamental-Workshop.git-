package edu.ingsoft.actividad.comportamiento.caso05;

/** SDK fabricante A (no modificable): brillo en porcentaje. */
public class LuzMarcaA {
    private final String lugar;
    private int brillo;

    public LuzMarcaA(String lugar) {
        this.lugar = lugar;
    }

    public void setBrillo(int porcentaje) {
        brillo = porcentaje;
        System.out.println("  luz " + lugar + " -> " + brillo + "%");
    }

    public int getBrillo() {
        return brillo;
    }
}
