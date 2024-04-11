package com.borjabolufer.primertrimestre.ejerciciosNavidad.stringybucles.ejercicio03;

public class Cesar {
    private final String contrasenya;
    private final int numero;
    private final String abecedario = "abcdefghijklmnñopqrstuvwxyz";
    private final String abecedarioMayu = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    public Cesar(String contrasenya, int numero) {
        this.contrasenya = contrasenya;
        this.numero = numero;
    }


    public String cifrar(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contrasenya.length(); i++){
            char posicionPass = contrasenya.charAt(i); 
            if (Character.isLowerCase(posicionPass)) {
                int indiceOriginal = abecedario.indexOf(posicionPass);
                int nuevoIndice = (indiceOriginal + numero) % abecedario.length();
                char ecriptado = abecedario.charAt(nuevoIndice);
                sb.append(ecriptado);
            }
            else{
                int indiceOriginal = abecedarioMayu.indexOf(posicionPass);
                int nuevoIndice = (indiceOriginal + numero) % abecedarioMayu.length();
                char ecriptado = abecedarioMayu.charAt(nuevoIndice);
                sb.append(ecriptado);
            }
        }
    return sb.toString();
    }

}
