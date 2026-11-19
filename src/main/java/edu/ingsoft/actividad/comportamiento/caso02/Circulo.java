package edu.ingsoft.actividad.comportamiento.caso02;

public class Circulo {
    public int x;
    public int y;
    public int radio;

    public Circulo(int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circ(" + x + "," + y + ")";
    }
}
