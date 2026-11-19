package edu.ingsoft.actividad.comportamiento.caso04;

public class SolicitudSupletorio {
    private final SiaLegado sia = new SiaLegado();
    private final Correo correo = new Correo();

    public String procesar(String estudiante, int creditos, String detalle) {
        if (!detalle.startsWith("INCAPACIDAD")) {
            return "Rechazada: requiere soporte de incapacidad";
        }
        long costo = 60_000;
        String aprobador = creditos <= 6 ? "Coordinador" : "Director de programa";
        correo.enviar(estudiante, "Supletorio aprobado por " + aprobador
                + ". Costo $" + costo); // notifica antes de registrar
        sia.llamar(512, estudiante + "/SUP/" + detalle);
        return "Supletorio OK (" + aprobador + ")";
    }
}
