package com.borjabolufer.segundotrimestre.tema08.calculadoraprofesor;

/**
 * Boton
 * License: 🅮 Public Domain
 * Calculadora
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-03-01
 * @since 0.1, 2024-03-01
 **/
public class Boton {
    public enum Accion {
        DIGITO, PUNTO, OPERADOR, IGUAL, ON, OFF, AC
    }
    private final String texto;
    private final Accion accion;

    public Boton(String texto, Accion accion) {
        this.texto = texto;
        this.accion = accion;
    }

    public Accion getAccion() {
        return accion;
    }

    public String getTexto() {
        return texto;
    }
}
