package com.borjabolufer.segundotrimestre.pila;

import com.borjabolufer.segundotrimestre.pila.ejercicio3.CodigoFuenteParser;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        Pila pila = new Pila(10);
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        ArrayList<String> a = new ArrayList<>();
        while (scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        CodigoFuenteParser codigoFuenteParser = new CodigoFuenteParser(sb.toString(), "{([", "})]");
        if (codigoFuenteParser.parse()){
            System.out.println("El documento esta bien formado");
        }
        else {
            System.out.println("El documento no está bien formado");
            System.out.println(codigoFuenteParser.getErrores());
        }
        String texto = sb.toString();
        texto = texto.replaceAll("\\s+", "");
        System.out.println(texto);
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 50; i++) {
//            String dato = String.valueOf(random.nextInt(75, 92));
//            if(random.nextBoolean()){
//                System.out.print(dato);
//                pila.push(dato);
//            }else {
//                dato = pila.pop();
//                if (dato != null) {
//                    sb.append(dato);
//                }
//            }
//        }
//        System.out.println();
//        System.out.println(sb.toString());


    }
}

