package com.borjabolufer.segundotrimestre.tema09.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio02 {
    private Scanner scanner;
    public double[] array;

    public Ejercicio02() {
        scanner = new Scanner(System.in);
        array = new double[10];
        double aux;

        int contExcepciones = 0;
        for (int i = 0; i < array.length; i++) {

            try {
                System.out.println("Introduzca un numero: ");
                array[i] = Double.parseDouble(scanner.nextLine());
                System.out.println("Número correcto");
            } catch (NumberFormatException e) {
                System.out.println("Solo se pueden introduzir números");
                contExcepciones++;
            }

        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
            System.out.println("El numero mas alto es: "+ array[array.length - 1]);
            System.out.println("Veces las cuales a salido la excepción: " + contExcepciones);
    }
}


