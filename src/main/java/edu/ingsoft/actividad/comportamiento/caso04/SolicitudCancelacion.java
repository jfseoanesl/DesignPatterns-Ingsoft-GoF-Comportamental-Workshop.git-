package edu.ingsoft.actividad.comportamiento.caso04;

public class SolicitudCancelacion {
    private final SiaLegado sia = new SiaLegado();
    private final Correo correo = new Correo();

    public String procesar(String estudiante, int creditos, String detalle) {
        long costo = 0;
        String aprobador;
        if (creditos <= 8) { // umbral desactualizado
            aprobador = "Coordinador";
        } else if (creditos <= 12) {
            aprobador = "Director de programa";
        } else {
            aprobador = "Consejo de facultad";
        }
        sia.llamar(450, "CAN;" + estudiante + ";" + creditos);
        correo.enviar(estudiante, "Cancelación aprobada por " + aprobador
                + ". Costo $" + costo);
        return "Cancelación OK (" + aprobador + ")";
    }
}
