package models;

import java.text.DecimalFormat;

public class Ahorros extends Cuenta {
    private double tasa;

    public Ahorros(String titular, String numero, double tasa) {
        super(titular, numero);
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    public void abonarIntereses() {
        setSaldo(getSaldo() + (1 + tasa / 100));
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[] {
            "AHORROS",
            getNumero(),
            getTitular(),
            "Tasa Interes = " + df.format(tasa) + "%",
            df.format(getSaldo())
        };
    }
}
