package edu.ingsoft.actividad.comportamiento.caso04;

/** Sistema académico heredado: operaciones por código numérico. No modificable. */
public class SiaLegado {
    public int llamar(int codigoOperacion, String parametros) {
        System.out.println("  [SIA op " + codigoOperacion + "] " + parametros);
        return 0; // 0 = éxito
    }
}
