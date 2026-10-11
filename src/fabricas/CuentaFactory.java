package fabricas;

import models.Cuenta;
import models.DatosCuenta;
import models.TipoCuenta;

public abstract class CuentaFactory {
    public abstract Cuenta crearCuenta(DatosCuenta datos);

    public static CuentaFactory getFactory(TipoCuenta tipo) {
        return switch (tipo) {
            case AHORROS -> new AhorrosFactory();
            case CREDITO -> new CreditoFactory();
            case CORRIENTE -> new CorrienteFactory();
        };
    }
}
