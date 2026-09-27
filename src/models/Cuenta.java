package models;

public abstract class Cuenta {
    private String titular;
    private String numero;
    private double saldo;

    public Cuenta() {

    }

    public Cuenta(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    //Metodo disponible solo para las clases HIJAS
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean retirar(double valor);

    public boolean depositar(double valor){
        if (valor > 0) {
            setSaldo(saldo + valor);
        }
        return false;
    }

    //Metodo que cada clase hija llenara con los datos a mostrar
    public abstract String[] getDatos();
}
