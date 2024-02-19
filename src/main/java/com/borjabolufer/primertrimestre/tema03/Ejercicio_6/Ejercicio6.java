package com.borjabolufer.primertrimestre.tema03.Ejercicio_6;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        float euro;
        int moneda2€ = 0, moneda1€ = 0, moneda50C = 0, monedas20C = 0, monedas10C = 0, moneda5C = 0, moneda2C = 0, moneda1C = 0;

        System.out.println("Ingrese cantidad de dinero en euros =");
        euro = Float.parseFloat(lector.nextLine());
        euro = euro * 100;
        lector.close();
	
	if (euro < 0) {
            System.out.println("ERROR!! La cantidad de dinero debe ser un número positivo.");
            System.exit(0);
        }

        if (euro >= 200) {
            moneda2€ = (int) euro / 200;
            euro = euro % 200;
        }
        if (euro >= 100) {
            moneda1€ = (int) euro / 100;
            euro = euro % 100;
        }
        if (euro >= 50) {
            moneda50C = (int) euro / 50;
            euro = euro % 50;
        }
        if (euro >= 20) {
            monedas20C = (int) euro / 20;
            euro = euro % 20;
        }
        if (euro >= 10) {
            monedas10C = (int) euro / 10;
            euro = euro % 10;
        }
        if (euro >= 5) {
            moneda5C = (int) euro / 5;
            euro = euro % 5;
        }
        if (euro >= 2) {
            moneda2C = (int) euro / 2;
            euro = euro % 2;
        }
        if (euro >= 1) {
            moneda1C = (int) euro / 1;
            euro = euro % 1;
        }

        System.out.println("Monedas de 2€: " + moneda2€);
        System.out.println("Monedas de 1€: " + moneda1€);
        System.out.println("Monedas de 50 centimos de €: " + moneda50C);
        System.out.println("Monedas de 20 centimos de €: " + monedas20C);
        System.out.println("Monedas de 10 centimos de €: " + monedas10C);
        System.out.println("Monedas de 5 centimos de €: " + moneda5C);
        System.out.println("Monedas de 2 centimos de €: " + moneda2C);
        System.out.println("Monedas de 1 centimo de €: " + moneda1C);
    }
}