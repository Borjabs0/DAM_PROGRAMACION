package com.borjabolufer.segundotrimestre.pila.ejercicio3;

import com.borjabolufer.segundotrimestre.pila.Pila;

public class CodigoFuenteParser {
    private String texto;
    private Pila pila;
    private String simbolosApertura;
    private String simbolosCierre;
    private final StringBuilder errores;

    public CodigoFuenteParser(String texto, String simbolosApertura, String simbolosCierre) {
        this.texto = texto.replaceAll("\\s+", "");
        this.simbolosApertura = simbolosApertura;
        this.simbolosCierre = simbolosCierre;
        pila = new Pila(20);
        errores = new StringBuilder();
    }
    public boolean parse(){
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (simbolosApertura.indexOf(c)>=0){//c es uno de los simbolos de apertura. Si se encuentra devuelve 0 y si no de encuentra -1
                pila.push(String.valueOf(c));
                //TODO: G3 2024-02-20 Eliminar después de testing
                System.out.printf("push(%c)\n", c);
            }else {
                int indice = simbolosCierre.indexOf(c);
                if(indice >= 0){
                    String dato = pila.pop();
                    System.out.printf("pop() → %s\n", simbolosCierre.charAt(indice));
                    if (dato == null){
                        errores.append("Se ha encontrado un").append(c).append(" sin apertura");
                        return false;
                    }
                    String apertura = simbolosApertura.substring(indice, indice + 1);
                    if(!dato.equals(apertura)){
                        errores.append("Se esperaba un ").append(dato).append(" pero ").append(c).append(" ha sido encontrado");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public StringBuilder getErrores(){
        return errores;
    }
}
