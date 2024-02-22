package com.borjabolufer.segundotrimestre.pila.ejercicio1;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rnd = new Random();
        DynamicArray dynamicArray = new DynamicArray();
        if (dynamicArray.set(10,100)){
            System.out.println("Déberia haber fallado");
        }
        for (int i = 0; i < 5; i++) {
            dynamicArray.add( rnd.nextDouble() * 1000);
        }
        System.out.println(dynamicArray);
        dynamicArray.set(3, 5);
        System.out.println(dynamicArray);
        dynamicArray.remove(4);
        System.out.println(dynamicArray);
        dynamicArray.add(10, 100);
        System.out.println(dynamicArray);
    }
}
