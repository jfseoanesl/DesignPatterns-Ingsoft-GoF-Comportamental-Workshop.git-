package edu.ingsoft.actividad.comportamiento.caso02;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private final List<Object> figuras = new ArrayList<>();
    private final List<List<Object>> versiones = new ArrayList<>();
    private Object ultimaFigura;
    private int ultimoDx;
    private int ultimoDy;

    public void agregar(Object f) {
        figuras.add(f);
    }

    public void mover(Object f, int dx, int dy) {
        if (f instanceof Rectangulo r) {
            r.x += dx;
            r.y += dy;
        } else if (f instanceof Circulo c) {
            c.x += dx;
            c.y += dy;
        } else if (f instanceof Grupo g) {
            for (Object h : g.hijos) {
                mover(h, dx, dy);
            }
        }
        ultimaFigura = f;
        ultimoDx = dx;
        ultimoDy = dy;
    }

    /** Solo sabe deshacer el último movimiento. */
    public void deshacer() {
        if (ultimaFigura != null) {
            Object f = ultimaFigura;
            mover(f, -ultimoDx, -ultimoDy);
            ultimaFigura = null;
        }
    }

    public Object duplicar(Object f) {
        Object copia;
        if (f instanceof Rectangulo r) {
            copia = new Rectangulo(r.x + 10, r.y + 10, r.ancho, r.alto);
        } else if (f instanceof Circulo c) {
            copia = new Circulo(c.x + 10, c.y + 10, c.radio);
        } else {
            Grupo g = (Grupo) f;
            Grupo n = new Grupo(g.nombre + "-copia");
            n.hijos = g.hijos; // comparte las figuras con el original
            copia = n;
        }
        figuras.add(copia);
        return copia;
    }

    public void guardarVersion() {
        versiones.add(new ArrayList<>(figuras)); // copia superficial
    }

    public void restaurarVersion(int i) {
        figuras.clear();
        figuras.addAll(versiones.get(i));
    }

    public String dibujar() {
        return figuras.toString();
    }
}
