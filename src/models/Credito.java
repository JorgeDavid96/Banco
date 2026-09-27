package models;

public class Credito extends Cuenta{
    private double valorPrestado;
    private double tasaInteres;
    private int plazo;
    private double valorRetirado;

    public Credito(String titular, String numero, double valorPrestado, double tasaInteres, int plazo) {
        super(numero, titular);
        this.valorPrestado = valorPrestado;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
        this.valorRetirado = 0;
    }

    public Credito() {

    }

    public double getValorPrestado() {
        return valorPrestado;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
    
    public int getPlazo() {
        return plazo;
    }

    public double getValorRetirado() {
        return valorRetirado;
    }

    public double getSaldoRetiro() {
        return valorPrestado - valorRetirado;
    }

    public double getCuota() {
        double factor = Math.pow(1 + tasaInteres / 100, plazo);
        return valorPrestado * factor * tasaInteres / (factor - 1);
    }

    public double getSaldoDeuda() {
        return valorPrestado - getSaldo();
    }

    public boolean pagar(double valor) {
        if (valor > 0 && getSaldo() < valorPrestado) {
            var intereses = getSaldoDeuda() * tasaInteres / 100;
            var abonoCapital = valor - intereses;
            if (abonoCapital <= getSaldoDeuda()) {
                return depositar(valor);
            }
        }
        return false;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= valorPrestado - valorRetirado) {
            valorRetirado += valor;
            return true;
        }
        return false;
    }

    @Override
    public String[] getDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDatos'");
    }
}
