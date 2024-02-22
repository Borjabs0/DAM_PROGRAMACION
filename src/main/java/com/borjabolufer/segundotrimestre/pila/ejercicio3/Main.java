package com.borjabolufer.segundotrimestre.pila.ejercicio3;

import com.borjabolufer.segundotrimestre.pila.ejercicio1.DynamicArray;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rnd = new Random();
        DynamicArray dynamicArray = new DynamicArray(5);
        for (int i = 0; i < dynamicArray.size(); i++) {
            dynamicArray.add( rnd.nextDouble() * 1000);
        }
        System.out.println(dynamicArray);
    }
}
