package com.borjabolufer.primertrimestre.tema03.Ejercicio_1;

import java.util.Scanner;
public class Ejercicio1{
	public static void main(String[]args ){
	Scanner lector = new Scanner(System.in);
	
	double numero;
	
	System.out.println("Numero =");
	numero = Double.parseDouble(lector.nextLine());
		
		if(numero % 2 == 0 ){
		System.out.println("El numero es par" );
		
		}
		else{
		System.out.println("El numero es impar" );
		
		}
	lector.close();
	}
}