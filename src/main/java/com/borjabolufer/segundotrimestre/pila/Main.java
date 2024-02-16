package com.borjabolufer.segundotrimestre.pila;

import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        Pila pila = new Pila(10);
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            sb.append(scanner.nextLine());
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

