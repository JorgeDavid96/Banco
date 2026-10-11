package fabricas;

import models.CreditoRotativo;
import models.Cuenta;
import models.DatosCuenta;

public class CreditoRotativoFactory extends CuentaFactory {
    @Override
    public Cuenta crearCuenta(DatosCuenta datos) {
        return new CreditoRotativo(datos.titular(), datos.numero(), datos.valorPrestado(), datos.tasaInteres(), datos.plazo());
    }
}
