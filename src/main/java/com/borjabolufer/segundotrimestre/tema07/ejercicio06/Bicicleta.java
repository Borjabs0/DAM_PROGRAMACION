package com.borjabolufer.segundotrimestre.tema07.ejercicio06;

public class Bicicleta {
    //private static int autoIncrement = 0;
    private String referencia;
    private final String marca;
    private final String modelo;
    private final float pesoKg;
    private final float pulgadas;
    private final boolean motor;
    private final String fechaFabricacion;
    private final float precio;
    private int existencias;

    public Bicicleta(String referencia, String marca, String modelo, float pesoKg, float pulgadas, boolean motor, String fechaFabricacion, float precio, int existencias) {
        this.referencia =  referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.pesoKg = pesoKg;
        this.pulgadas = pulgadas;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Bicicleta(String marca, String modelo, float pesoKg, float pulgadas, boolean motor, String fechaFabricacion, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.pesoKg = pesoKg;
        this.pulgadas = pulgadas;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
    }


    public String getReferencia() {
        return referencia;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public boolean isMotor() {
        return motor;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }
    public void comprar(){
        existencias++;
    }
    public boolean vender(){
        if (existencias < 1)
            return false;
        existencias--;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bicicleta bicicleta = (Bicicleta) o;

        return referencia.equals(bicicleta.referencia);
    }

    @Override
    public int hashCode() {
        return referencia.hashCode();
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "referencia='" + referencia + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", pesoKg=" + pesoKg +
                ", pulgadas=" + pulgadas +
                ", motor=" + motor +
                ", fechaFabricacion='" + fechaFabricacion + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                '}';
    }
}

