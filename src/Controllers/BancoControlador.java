package Controllers;

import Services.CuentaServicio;
import models.TipoCuenta;
import vistas.BancoVista;

public class BancoControlador {
    private BancoVista vista;

    public BancoControlador(BancoVista vista) {
        this.vista = vista;
        this.vista.setGuardarCuentaClick(evento -> agregarCuenta());
        mostrarCuentas();
    }

    public void mostrarCuentas() {
        vista.mostrarCuentas(CuentaServicio.getDatos(), CuentaServicio.getEncabezados());
    }

    private void agregarCuenta() {
        var tipo = vista.getTipoCuentaSeleccionada();
        var titular = vista.getTitular();
        var numero = vista.getNumero();
        var tasaInteres = tipo == TipoCuenta.AHORROS || tipo == TipoCuenta.CREDITO ?
            vista.getTasaInteres() : 0;
        var sobreGiro = tipo == TipoCuenta.CORRIENTE ?
            vista.getValor() : 0;
        var plazo = tipo == TipoCuenta.CREDITO ?
            vista.getPlazo() : 0;
        var valorPrestado = tipo == TipoCuenta.CREDITO ?
            vista.getValor() : 0;

        CuentaServicio.agregar(tipo, titular, numero, tasaInteres, sobreGiro, plazo, valorPrestado);
        
        vista.ocultarEdicionCuenta();
        mostrarCuentas();
    }
}
