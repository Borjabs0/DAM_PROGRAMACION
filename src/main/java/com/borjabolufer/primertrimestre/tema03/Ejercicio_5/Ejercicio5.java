package com.borjabolufer.primertrimestre.tema03.Ejercicio_5;

import java.util.Scanner;
public class Ejercicio5{
	public static void main(String[]args ){
	Scanner lector = new Scanner(System.in);
	
	int calificacion;

	System.out.println("Ingrese su calificacion =");
	calificacion = Integer.parseInt(lector.nextLine());

	lector.close();
	
	  if (calificacion < 5) {
            System.out.println("INSUFICIENTE");
        } else if (calificacion >= 5 && calificacion <= 6) {
            System.out.println("BIEN");
        } else if (calificacion >= 7 && calificacion < 9) {
            System.out.println("NOTABLE");
        } else if (calificacion >= 9 && calificacion <= 10) {
            System.out.println("SOBRESALIENTE");
        } else {
            System.out.println("ERROR");
        }
		
	}
}