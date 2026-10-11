package fabricas;

import models.Corriente;
import models.Cuenta;
import models.DatosCuenta;

public class CorrienteFactory extends CuentaFactory{
    @Override
    public Cuenta crearCuenta(DatosCuenta datos) {
        return new Corriente(datos.titular(), datos.numero(), datos.sobreGiro());
    }
}