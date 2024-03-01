package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;

//Clases para operadores utilizar switch
public class Calculadora {
    public enum Estado {
        OPERANDO_ENTERO, PUNTO, OPERANDO_DECIMAL, OPERADOR, ERROR
    }

    private final StringBuilder operando1;

    private final StringBuilder operando2;
    private StringBuilder operandoActual;
    private Estado estadoActual;
    private String operando;
    private final Estado[][] diagramaDeEstados;

    public Calculadora() {
        operando1 = new StringBuilder();
        operando2 = new StringBuilder();
        operandoActual = operando1;
        estadoActual = Estado.OPERANDO_ENTERO;
        diagramaDeEstados = new Estado[][]{
                // OPERANDO_ENTERO
                {Estado.OPERANDO_ENTERO, Estado.PUNTO, Estado.OPERADOR, Estado.ERROR},
                // PUNTO
                {Estado.OPERANDO_DECIMAL, Estado.ERROR},
                // OPERANDO_DECIMAL
                {Estado.OPERANDO_DECIMAL, Estado.OPERADOR, Estado.ERROR},
                // OPERADOR
                {Estado.OPERANDO_ENTERO, Estado.ERROR},
                // ERROR
                {Estado.ERROR}
        };
    }

    public void addDigito(String digito) {
        if (estadoActual == Estado.ERROR) {
            return;
        }
        Estado siguienteEstado = Estado.OPERANDO_ENTERO;
        if (estadoActual == Estado.OPERANDO_DECIMAL || estadoActual == Estado.PUNTO)
            siguienteEstado = Estado.OPERANDO_DECIMAL;
        if (!esTransicionValida(siguienteEstado)) {
            error();
            return;
        }
        if (digito == null || digito.length() > 1 || !Character.isDigit(digito.charAt(0))){
            error();
            return;
        }
        operandoActual.append(digito);
        estadoActual = siguienteEstado;
    }


    private void error() {
        estadoActual = Estado.ERROR;
    }

    private boolean esTransicionValida(Estado siguienteEstado) {
        Estado[] estadosTransitables = diagramaDeEstados[estadoActual.ordinal()]; // Obtenemos el numero  de la posicion de la matriz
        for (Estado estado : estadosTransitables) {
            if (estado == siguienteEstado) {
                return true;
            }
        }
        return false;
    }
}
