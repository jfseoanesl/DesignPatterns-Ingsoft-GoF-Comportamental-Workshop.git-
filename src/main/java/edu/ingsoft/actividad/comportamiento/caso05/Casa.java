package edu.ingsoft.actividad.comportamiento.caso05;

public class Casa {
    final RegistroDispositivos registro = new RegistroDispositivos();
    final LuzMarcaA luzSala = new LuzMarcaA("sala");
    final LuzMarcaA luzPasillo = new LuzMarcaA("pasillo");
    final PersianaMarcaB persiana = new PersianaMarcaB();
    final AireMarcaC aire = new AireMarcaC();
    final CerraduraMarcaD cerradura = new CerraduraMarcaD(persiana);
    final SensorMovimiento sensor = new SensorMovimiento(luzPasillo, cerradura);

    public Casa() {
        registro.registrar(luzSala);
        registro.registrar(luzPasillo);
        registro.registrar(persiana);
        registro.registrar(aire);
    }

    public void modoCine() {
        System.out.println(" escena: modo cine");
        luzSala.setBrillo(20);
        persiana.posicion(100); // se quería «cerrada»; el SDK usa 0–255
        aire.setFahrenheit(72);
    }

    public void salirDeCasa() {
        System.out.println(" escena: salir de casa");
        luzSala.setBrillo(0);
        luzPasillo.setBrillo(0);
        aire.apagar();
        cerradura.bloquear(); // la persiana se cierra como efecto secundario
    }
}
