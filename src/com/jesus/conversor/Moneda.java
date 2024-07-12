package com.jesus.conversor;

public class Moneda {
    private String nombre;
    private double tasaCambio;

    public Moneda(String nombre, double tasaCambio) {
        this.nombre = nombre;
        this.tasaCambio = tasaCambio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public double convertirDesdeUsd(double cantidadEnUsd) {
        return cantidadEnUsd * tasaCambio;
    }

    public double convertirAUsd(double cantidadEnMoneda) {
        return cantidadEnMoneda / tasaCambio;
    }
}
