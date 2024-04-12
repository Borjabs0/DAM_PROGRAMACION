package com.borjabolufer.segundotrimestre.tema09.ejercicio04;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {
    private Scanner scanner;

    public void solicitarNumeros(int[] array) {
        scanner = new Scanner(System.in);
        if (array == null) {
            System.out.println("El array no está creado");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("Inserte un numero: ");
                array[i] = Integer.parseInt(scanner.nextLine());
                System.out.println("Numero insertado correctamente");
            } catch (NumberFormatException e) {
                System.out.println("Se ha insertado una letra. Vuele a intentarlo");
                i--; // Volvemos a intentar ingresar el numero en la misma posición
            } catch (ArrayIndexOutOfBoundsException b) {
                System.out.println("As sobrepasado la canatidad del array");
                break;
            }
        }
        //Mostrar el contenido del array
        System.out.println();
        System.out.println("Array: ");
        int cont = 0;
        for (int i : array) {
            System.out.println("Posicion " + cont++ + ": " + i + " ");
        }
    }
}


