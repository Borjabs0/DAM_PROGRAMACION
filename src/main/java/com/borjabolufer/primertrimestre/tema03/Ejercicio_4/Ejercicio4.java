package com.borjabolufer.primertrimestre.tema03.Ejercicio_4;

import java.util.Scanner;
public class Ejercicio4{
	public static void main(String[]args ){
	Scanner lector = new Scanner(System.in);
	
	double numeroUno;
	double numeroDos;

	
	System.out.println("Ingrese el primer numero real =");
	numeroUno = Double.parseDouble(lector.nextLine());
	System.out.println("Ingrese el segundo numero real =");
	numeroDos = Double.parseDouble(lector.nextLine());

	lector.close();
	
	if(numeroUno > numeroDos)
		System.out.println("Los números en orden ascendente son: " + numeroUno + ", " + numeroDos);
		
	else if(numeroUno == numeroDos)
		System.out.println("El primer numero es igual que el segundo " + numeroUno + ", " + numeroDos);
		
	else
		System.out.println("Los números en orden descendente son: " + numeroUno + ", " + numeroDos);
		
	}
}