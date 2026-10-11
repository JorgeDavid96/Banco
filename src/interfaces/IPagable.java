package interfaces;

public interface IPagable {
    boolean pagar(double valor);
    double getCuota();
    double getSaldoDeuda();
}
