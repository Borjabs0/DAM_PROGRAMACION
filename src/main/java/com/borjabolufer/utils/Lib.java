package com.borjabolufer.utils;

import java.util.Random;
import java.util.Scanner;

public class Lib {
    public static Scanner lector = new Scanner(System.in);
    private static final Random r = new Random();

    public static void pause() {
        System.out.println("Pulsa INTRO para continuar...");
        lector.nextLine();
    }

    public static int random() {
        return r.nextInt();
    }

    public static int random(int min, int max) {
        return r.nextInt(max - min +1 ) + min;
    }

    public static double random(double min, double max) {
        return min + r.nextDouble() * (max - min);
    }

    public static float random(float min, float max) {
        return min + r.nextFloat() * (max - min);
    }
}