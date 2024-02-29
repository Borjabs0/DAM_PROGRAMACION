package com.borjabolufer.segundotrimestre.pila;

public class GenericPila<T> {
    private  Object[] datos;
    private int tope;
    public GenericPila(int capacidadInicial) {
        datos = new Object[capacidadInicial];
        tope = -1;
    }
    public void push(T elemento){
        if (isFull()){
            ampliarArray();
        }
        datos[++tope] = elemento;
    }//Ejercicios para mañana implementar pop y size
    //El metodo pop nos servira para coger y eliminar el elemento tope de la pila
    //El metodo size nos servira para determinar el tamaño de la pila
    public T pop(){
        if(isEmpty()){
            //  System.err.println("La pila esta vacía, no se ha podido eliminar al elemento");
            return null;
        }
        return (T)datos[tope--];//Retorna el elemento tope y luego lo decrementa
    }
    public int size(){
        return tope + 1;//El tamaño de la pila es igual al índice del tope más 1
    }

    private void ampliarArray() {
        Object[] nuevoArray = new Object[datos.length * 2];
        for (int i = 0; i < datos.length; i++) {
            nuevoArray[i] = datos[i];
        }
        datos = nuevoArray;
    }

    private boolean isFull(){//Comprueba si esta llena la pila
        return  tope == datos.length - 1;
    }
    public  boolean isEmpty(){//Comprueba si esta vacia la pila
        return  tope == -1;
    }
}