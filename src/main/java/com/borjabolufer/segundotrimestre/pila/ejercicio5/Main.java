package com.borjabolufer.segundotrimestre.pila.ejercicio5;

import com.borjabolufer.segundotrimestre.pila.Pila;

public class Main {

    public static void main(String[] args) {
        RPN calculadora = new RPN(10);
        calculadora.push(3);
        calculadora.push(5);

        System.out.println("La calculadora tiene " + calculadora.size() + " elementos");
        for (int i = 0; i < calculadora.size(); i++) {
            System.out.println(calculadora.data[i]);
        }
        System.out.println("El resultado de multiplicar los dos últimos elementos es: " + RPN.operation("*", calculadora));

    }

}
