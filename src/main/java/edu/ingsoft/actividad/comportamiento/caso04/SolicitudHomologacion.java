package edu.ingsoft.actividad.comportamiento.caso04;

public class SolicitudHomologacion {
    private final SiaLegado sia = new SiaLegado();
    private final Correo correo = new Correo();

    public String procesar(String estudiante, int creditos, String detalle) {
        if (detalle == null || detalle.isBlank()) {
            return "Rechazada: falta el certificado de notas";
        }
        long costo = 25_000L * creditos;
        String aprobador;
        if (creditos <= 6) {
            aprobador = "Coordinador";
        } else if (creditos <= 12) {
            aprobador = "Director de programa";
        } else {
            aprobador = "Consejo de facultad";
        }
        sia.llamar(301, estudiante + "|HOM|" + creditos + "|" + detalle);
        correo.enviar(estudiante, "Homologación aprobada por " + aprobador
                + ". Costo $" + costo);
        return "Homologación OK (" + aprobador + ")";
    }
}
