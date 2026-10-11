package models;

import java.text.DecimalFormat;

import interfaces.IConsignable;
import interfaces.IGeneraIntereses;
import interfaces.IRetirable;

public class Ahorros extends Cuenta implements IConsignable, IGeneraIntereses, IRetirable {
    private double tasa;

    public Ahorros(String titular, String numero, double tasa) {
        super(titular, numero);
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    @Override
    public boolean procesarTransaccion(TipoTransaccion tipo, double valor) {
        switch (tipo) {
            case DEPOSITO:
                return consignar(valor);
            case RETIRO:
                return retirar(valor);
        }
        return false;
    }

    @Override
    public boolean consignar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public double getSaldoRetiro() {
        return getSaldo();
    }

    @Override
    public double calcularIntereses() {
        return getSaldo() * tasa / 100;
    }

    public void abonarIntereses() {
        setSaldo(getSaldo() + calcularIntereses());
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

    @Override
    public String toString() {
        return "AHORRO $[" + getNumero() + "] Titular[" + getTitular() + "]";
    }
}
