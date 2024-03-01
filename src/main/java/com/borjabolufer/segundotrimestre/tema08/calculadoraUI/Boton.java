package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;

public class Boton {

    public enum Accion {
        DIGITO, PUNTO, OPERADOR,IGUAL , ON, OFF, AC
    }
    private String texto;
    private  Accion accion;

    public Boton(String texto, Accion accion) {
        this.texto = texto;
        this.accion = accion;
    }
}
