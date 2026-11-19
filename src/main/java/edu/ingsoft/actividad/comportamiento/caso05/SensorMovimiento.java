package edu.ingsoft.actividad.comportamiento.caso05;

public final class SensorMovimiento {
    private final LuzMarcaA luzPasillo;
    private final CerraduraMarcaD cerradura;

    public SensorMovimiento(LuzMarcaA luzPasillo, CerraduraMarcaD cerradura) {
        this.luzPasillo = luzPasillo;
        this.cerradura = cerradura;
        new RegistroDispositivos().registrar(this); // registro propio
    }

    public void detectar(int hora) {
        System.out.println(" sensor: movimiento a las " + hora + "h");
        if (hora >= 22 || hora < 6) {
            luzPasillo.setBrillo(40);
            cerradura.bloquear();
        }
    }
}
