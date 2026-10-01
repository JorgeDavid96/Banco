package Services;

import java.util.List;
import java.util.ArrayList;

import models.Cuenta;
import models.TipoTransaccion;
import models.Transaccion;

public class TransaccionServicio {
    private static String[] encabezados = new String[] {
        "Cuenta",
        "Tipo",
        "Valor Transaccion",
        "Saldo"
    };

    private static List<Transaccion> transacciones = new ArrayList();

    public static String[] getEncabezados() {
        return encabezados;
    }

    public String[][] getDatos() {
        String[][] datos = new String[transacciones.size()][encabezados.length];
        int fila = 0;
        for(var transaccion : transacciones) {
            int columna = 0;
            for(var dato : transaccion.getDatos()) {
                if (columna < encabezados.length) {
                    datos[fila][columna] = dato;
                    columna++;
                }
            }
            fila++;
        }
        return datos;
    }

    public static Transaccion agregar(Cuenta cuenta, TipoTransaccion tipo, double valor) {
        Transaccion transaccion = null;
        if (cuenta.procesarTransaccion(tipo, valor)) {
            transaccion = new Transaccion(cuenta, tipo, valor, cuenta.getSaldoTransaccion(tipo));
            transacciones.add(transaccion)
        }
        return transaccion;
    }
}