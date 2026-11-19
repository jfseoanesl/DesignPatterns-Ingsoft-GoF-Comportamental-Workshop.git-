package edu.ingsoft.actividad.comportamiento.caso01;

public class Notificador {
    public void enviar(String cliente, String msg) {
        System.out.println("  [notificación a " + cliente + "] " + msg);
    }
}
