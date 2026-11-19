package edu.ingsoft.actividad.comportamiento.caso05;

public class Demo {
    public static void main(String[] args) {
        Casa casa = new Casa();
        casa.modoCine();
        System.out.println(" (no hay forma de deshacer el modo cine)");
        casa.sensor.detectar(23);
        casa.salirDeCasa();
        System.out.println("Dispositivos en el registro de la casa: " + casa.registro.total()
                + " (hay 6 instalados)");
    }
}
