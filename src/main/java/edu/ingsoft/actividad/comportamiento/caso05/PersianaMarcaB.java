package edu.ingsoft.actividad.comportamiento.caso05;

/** SDK fabricante B (no modificable): posición de 0 (abierta) a 255 (cerrada). */
public class PersianaMarcaB {
    private int nivel;

    public void posicion(int nivel0a255) {
        nivel = nivel0a255;
        System.out.println("  persiana -> nivel " + nivel + "/255");
    }

    public int nivel() {
        return nivel;
    }
}
