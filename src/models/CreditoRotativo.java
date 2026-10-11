package models;

import java.text.DecimalFormat;

import interfaces.IMostrable;
import interfaces.IPagable;
import interfaces.IRetirable;

public class CreditoRotativo extends Cuenta implements IPagable, IRetirable, IMostrable {
    private double cupo;
    private double tasaInteres;
    private int plazo;

    public CreditoRotativo(String titular, String numero, double cupo, double tasaInteres, int plazo) {
        super(numero, titular);
        this.cupo = cupo;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
    }

    @Override
    public double getSaldoDeuda() {
        return -getSaldo();
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[] {
            "CREDITO",
            getNumero(),
            getTitular(),
            "Valor Cupo $" + df.format(cupo) + " Tasa Interes " + df.format(tasaInteres) + "% Plazo " + plazo + " Cuota $" + df.format(getCuota()),
            "Saldo Adeudado $" + df.format(getSaldoDeuda())
        };
    }

    @Override
    public boolean pagar(double valor) {
        if (valor > 0) {
            var intereses = getSaldoDeuda() * tasaInteres / 100;
            var abonoCapital = valor - intereses;
            if (abonoCapital > 0 && abonoCapital <= getSaldoDeuda()) {
                setSaldo(getSaldo() + abonoCapital);
                return true;
            }
        }
        return false;
    }

    @Override
    public double getCuota() {
        double tasa = tasaInteres / 100;
        double factor = Math.pow(1 + tasa, plazo);
        return getSaldoDeuda() * factor * tasa / (factor - 1);
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= valorPrestado - valorRetirado) {
            valorRetirado += valor;
            return true;
        }
    }
}
