package com.borjabolufer.primertrimestre.tema03.Ejercicio_2;

import java.util.Scanner;
public class Ejercicio2{
	public static void main(String[]args ){
	Scanner lector = new Scanner(System.in);
	
	int numeroUno;
	int numeroDos;

	
	System.out.println("Primer Numero =");
	numeroUno = Integer.parseInt(lector.nextLine());
	System.out.println("Segundo Numero =");
	numeroDos = Integer.parseInt(lector.nextLine());
			
		if(numeroUno > numeroDos)
		System.out.println("El primer numero es mayor que el segundo" );
		
		else if(numeroUno == numeroDos)
		System.out.println("El primer numero es igual que el segundo" );
		
		else
		System.out.println("El primer numero es menor que el segundo" );
		
	lector.close();
	}
}