package models;

import java.text.DecimalFormat;

public class Corriente extends Cuenta {
    private double sobreGiro;

    public Corriente(String titular, String numero, double tasa) {
        super(titular, numero);
        this.sobreGiro = sobreGiro;
    }

    public double getSobreGiro() {
        return sobreGiro;
    }

    @Override 
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= getSaldo() + sobreGiro) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[] {
            "CORRIENTE",
            getNumero(),
            getTitular(),
            "Sobre Giro = $" + df.format(sobreGiro),
            df.format(getSaldo())
        };
    }
}
