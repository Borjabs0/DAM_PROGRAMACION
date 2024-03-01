package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;
//Clases para operadores utilizar switch
public class Calculadora {
    public enum Estado{
        OPERADOR_ENTERO, PUNTO, OPERANDO_DECIMAL, OPERADOR, ERROR
    }
    private Estado estadoActual;
    private Estado[][] diagramaDeEstado;
    public Calculadora() {
        estadoActual = Estado.OPERADOR_ENTERO;
        diagramaDeEstado = new Estado[][]{
                {Estado.OPERADOR_ENTERO, Estado.PUNTO, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERADOR_ENTERO, Estado.ERROR},
                {Estado.ERROR}
        };
    }
}
