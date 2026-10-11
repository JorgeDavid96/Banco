package fabricas;

import models.Credito;
import models.Cuenta;
import models.DatosCuenta;

public class CreditoFactory extends CuentaFactory {
    @Override
    public Cuenta crearCuenta(DatosCuenta datos) {
        return new Credito(datos.titular(), datos.numero(), datos.valorPrestado(), datos.tasaInteres(), datos.plazo());
    }
}
