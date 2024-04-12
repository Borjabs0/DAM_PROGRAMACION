package com.borjabolufer.segundotrimestre.tema09.ejercicio01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {
    private Scanner scanner;
    public ArrayList<Integer> arrayList;

    public Ejercicio01() {
        arrayList = new ArrayList<>();

        scanner = new Scanner(System.in);
        int num = 1;
        while (num >= 0) {
            System.out.println("Introduzca un numero: ");
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= 0)
                    arrayList.add(num);
                System.out.println("Número correcto");
            } catch (NumberFormatException e) {
                System.out.println("Solo se pueden introduzir números");
            }
        }
        System.out.println(arrayList);
    }
}
