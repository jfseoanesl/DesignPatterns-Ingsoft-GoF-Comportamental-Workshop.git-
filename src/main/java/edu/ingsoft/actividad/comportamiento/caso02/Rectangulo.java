package edu.ingsoft.actividad.comportamiento.caso02;

public class Rectangulo {
    public int x;
    public int y;
    public int ancho;
    public int alto;

    public Rectangulo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Rect(" + x + "," + y + ")";
    }
}
