package fabricas;

import models.CreditoRotativo;
import models.Cuenta;
import models.DatosCuenta;

public class CreditoRotativoFactory {
    @Override
    public Cuenta crearCuenta(DatosCuenta datos) {
        return new CreditoRotativo(datos.titular(), datos.numero(), datos.cupo(), datos.tasaInteres());
    }
}
