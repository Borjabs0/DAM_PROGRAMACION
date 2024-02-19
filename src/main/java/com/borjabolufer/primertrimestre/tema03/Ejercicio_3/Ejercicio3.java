package com.borjabolufer.primertrimestre.tema03.Ejercicio_3;

import java.util.Scanner;
public class Ejercicio3{
	public static void main(String[]args ){
	Scanner lector = new Scanner(System.in);
	
	int edad;

	
	System.out.println("Dime tu edad =");
	edad = Integer.parseInt(lector.nextLine());
			
		if(18 >= edad)
		System.out.println("Es mayor de edad" );
		
		else
		System.out.println("No es mayor de edad" );
		
		
	lector.close();
	}
}