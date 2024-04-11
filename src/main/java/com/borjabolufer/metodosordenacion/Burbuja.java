package com.borjabolufer.metodosordenacion;

import javax.swing.*;
import java.util.Scanner;

public class Burbuja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de elementos que desas que tenga el array: "));
        int[] array = new int[numElementos];
        int aux;

        for (int i = 0; i < numElementos; i++) {
            System.out.println((i + 1) + ". Introduzca un numero: ");
            array[i] = scanner.nextInt();
        }

        //Metodo Burbuja
        for (int i = 0; i < numElementos - 1; i++) {//For para el numero de veces que recoremos el array
            for (int j = 0; j < numElementos - 1; j++) {//For para ordenar el array
                if (array[j] > array[j + 1]){ //Si numero actual > al numero siguiente
                    aux = array[j];//Aux sea igual al numero actual
                    array[j] = array[j + 1];// Al numereo actual le agregamos el valor del numero siguiente
                    array[j + 1] = aux; //El numero siguiente va ser igual al numero actual que esta dentro de aux
                }
            }
        }
        //Mostrar el array ordenado
        System.out.println("Arreglo ordenado: ");
        for (int i = 0; i < numElementos; i++) {
            System.out.print(array[i] + " - ");
        }
        System.out.println();
    }
}
