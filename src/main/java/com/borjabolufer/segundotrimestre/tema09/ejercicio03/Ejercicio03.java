package com.borjabolufer.segundotrimestre.tema09.ejercicio03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {
    private Scanner scanner;
    public ArrayList<Integer> arrayList;

    public Ejercicio03() {
        scanner = new Scanner(System.in);
        arrayList = new ArrayList<>();
        int aux;

        boolean continuar = true; // Variable para controlar la continuacion del bucle

        // Bucle para solicitar numeros al usuario hasta que se ingrese una letra
        do {
            try {
                System.out.println("Introduce un número (o letras para terminar): ");
                arrayList.add(Integer.parseInt(scanner.nextLine()));
                System.out.println("Número correcto");
            } catch (NumberFormatException e) {
                continuar = false;
            }
        } while (continuar);

        /**
         * Ordenacion burbuja utilizando ArrayList
         */
        for (int i = 0; i < arrayList.toArray().length - 1; i++) {
            for (int j = 0; j < arrayList.toArray().length - 1; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) { // Si numero actual (j) es mayor al numero siguiente (j + 1)
                    aux = arrayList.get(j); // Se guarda el numero actual en la variable aux
                    //Se intercambian los valores entre el numero actual y el siguiente
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, aux);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            System.out.println("El numero mas alto es: " + arrayList.get(arrayList.toArray().length - 1));
        } else {
            System.out.println("No se ingresaron numeros");
        }
    }
}


