package com.borjabolufer.Lib;
import java.util.Scanner;
public class Solicitar {
    public static Scanner lector = new Scanner(System.in);
        public static void solicitarDatosArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("a[%d]\n", i);
                array[i] = Integer.parseInt(lector.nextLine());
            }
        }

    }

