package edu.ingsoft.actividad.comportamiento.caso01;

/** Cliente de la transportadora (externo, no modificable). Espera "ORIG|DEST|PESO". */
public class RapiEnviosApi {
    public String crearGuia(String payload) {
        return "RAPI-" + Math.abs(payload.hashCode() % 100_000);
    }
}
