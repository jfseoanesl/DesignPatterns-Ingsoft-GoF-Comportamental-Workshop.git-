package edu.ingsoft.actividad.comportamiento.caso05;

/** SDK fabricante D, modificado internamente para reaccionar con la persiana. */
public class CerraduraMarcaD {
    private final PersianaMarcaB persiana;

    public CerraduraMarcaD(PersianaMarcaB persiana) {
        this.persiana = persiana;
    }

    public void bloquear() {
        System.out.println("  cerradura -> bloqueada");
        persiana.posicion(255);
    }

    public void desbloquear() {
        System.out.println("  cerradura -> desbloqueada");
    }
}
