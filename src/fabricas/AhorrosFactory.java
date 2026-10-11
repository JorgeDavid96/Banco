package fabricas;

import models.Ahorros;
import models.Cuenta;
import models.DatosCuenta;

public class AhorrosFactory extends CuentaFactory {
    @Override
    public Cuenta crearCuenta(DatosCuenta datos){
        return new Ahorros(datos.titular(), datos.numero(), datos.tasaInteres());
    }
}
