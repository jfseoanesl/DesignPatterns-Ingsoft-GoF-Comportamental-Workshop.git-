package edu.ingsoft.actividad.comportamiento.caso04;

public class Demo {
    public static void main(String[] args) {
        ControladorSolicitudes c = new ControladorSolicitudes();
        System.out.println(c.radicar("HOMOLOGACION", "est-1001", 8, "certificado-uni-x.pdf"));
        System.out.println(c.radicar("CANCELACION", "est-1002", 8, null));
        System.out.println(c.radicar("SUPLETORIO", "est-1003", 3, "INCAPACIDAD-EPS-778"));
        System.out.println(c.radicar("HOMOLOGACION", "est-1004", 15, ""));
        System.out.println(c.radicar("REINTEGRO", "est-1005", 16, "carta.pdf"));
    }
}
