package Services;

import java.util.List;

import javax.swing.JTable;

import models.Ahorros;
import models.Corriente;
import models.Credito;
import models.Cuenta;
import models.TipoCuenta;

public class CuentaServicio {
    private static String[] encabezados = new String[] { "Tipo", "Número", "Titular", "Parametros del producto", "Saldo"};

    private static List<Cuenta> cuentas;

    public static String[] getEncabezados() {
        return encabezados;
    };

    public static Cuenta agregar(TipoCuenta tipo, String titular, String numero, double tasaInteres, double Sobregiro, int plazo, double valorPrestado) {
        Cuenta cuenta = null;

        switch (tipo) {
            case AHORROS:
                cuenta = new Ahorros(titular, numero, tasaInteres);
                break;
            case CORRIENTE:
                cuenta = new Corriente(titular, numero, Sobregiro);
                break;
            case CREDITO:
                cuenta = new Credito(titular, numero, valorPrestado, tasaInteres, plazo);
                break;
        }
        if (cuenta != null) {
            cuentas.add(cuenta);
        }
        return cuenta;
    }

    public static String[][] getDatos() {
        String[][] datos = new String[cuentas.size()][encabezados.length];
        for(Cuenta cuenta : cuentas){
            
        }
        return datos;
    }
}
