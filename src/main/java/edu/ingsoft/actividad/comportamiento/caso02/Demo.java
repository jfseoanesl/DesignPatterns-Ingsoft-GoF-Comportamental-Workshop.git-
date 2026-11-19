package edu.ingsoft.actividad.comportamiento.caso02;

public class Demo {
    public static void main(String[] args) {
        Editor e = new Editor();
        Grupo logo = new Grupo("Logo");
        logo.hijos.add(new Rectangulo(0, 0, 50, 20));
        logo.hijos.add(new Circulo(25, 10, 5));
        e.agregar(logo);
        e.agregar(new Circulo(100, 100, 30));
        System.out.println("Inicial:           " + e.dibujar());

        e.guardarVersion();
        Object copia = e.duplicar(logo);
        e.mover(copia, 200, 0);
        System.out.println("Duplicar y mover:  " + e.dibujar());
        e.deshacer();
        e.deshacer();
        System.out.println("Deshacer x2:       " + e.dibujar());
        e.restaurarVersion(0);
        System.out.println("Restaurar v0:      " + e.dibujar());
    }
}
