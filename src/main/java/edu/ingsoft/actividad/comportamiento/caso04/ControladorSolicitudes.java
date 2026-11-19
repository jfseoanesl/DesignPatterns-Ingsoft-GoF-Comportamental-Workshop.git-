package edu.ingsoft.actividad.comportamiento.caso04;

public class ControladorSolicitudes {

    public String radicar(String tipo, String estudiante, int creditos, String detalle) {
        switch (tipo) {
            case "HOMOLOGACION":
                return new SolicitudHomologacion().procesar(estudiante, creditos, detalle);
            case "CANCELACION":
                return new SolicitudCancelacion().procesar(estudiante, creditos, detalle);
            case "SUPLETORIO":
                return new SolicitudSupletorio().procesar(estudiante, creditos, detalle);
            default:
                return "Tipo de solicitud no soportado: " + tipo;
        }
    }
}
