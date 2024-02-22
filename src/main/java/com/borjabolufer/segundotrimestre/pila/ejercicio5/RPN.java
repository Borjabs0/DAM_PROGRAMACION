package com.borjabolufer.segundotrimestre.pila.ejercicio5;

public class RPN {
    public double[] data;
    private int tope;
    public RPN(int capacidadInicial) {
        data = new double[capacidadInicial];
        tope = -1;
    }
    public void push(double elemento){
        if (isFull()){
            ampliarArray();
        }
        data[++tope] = elemento;
    }
    //El metodo pop nos servira para coger y eliminar el elemento tope de la pila
    //El metodo size nos servira para determinar el tamaño de la pila
    public double pop(){
        if(isEmpty()){
            //  System.err.println("La pila esta vacía, no se ha podido eliminar al elemento");
            return Double.NEGATIVE_INFINITY;
        }
        return data[tope--];//Retorna el elemento tope y luego lo decrementa
    }
    public int size(){
        return tope + 1;//El tamaño de la pila es igual al índice del tope más 1
    }

    private void ampliarArray() {
        double[] nuevoArray = new double[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            nuevoArray[i] = data[i];
        }
        data = nuevoArray;
    }

    public boolean isFull(){//Comprueba si esta llena la pila
        return  tope == data.length - 1;
    }
    public  boolean isEmpty(){//Comprueba si esta vacia la pila
        return  tope == -1;
    }

    public static double operation(String opcion, RPN calculadora) {
        double first = calculadora.pop(); //Obtiene el primer operando
        double second = calculadora.pop(); //Obtiene el segundo operando
        double result = 0; //Almacena el resultado
            switch (opcion) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                    break;
                case "^":
                    result = Math.pow(first, second);
                    break;
            }
            calculadora.push(result);
            return result;
    }
}
