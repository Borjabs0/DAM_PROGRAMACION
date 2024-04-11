package com.borjabolufer.primertrimestre.tema02.Ejercicio02;

public class Ejercicio2 {


    public double calcularDescuento(double precio, int descuento){
        double aplicacionDescuento = ((double) descuento / 100) * precio;
        return precio - aplicacionDescuento;//Devolvemos el precio final
    }
}
