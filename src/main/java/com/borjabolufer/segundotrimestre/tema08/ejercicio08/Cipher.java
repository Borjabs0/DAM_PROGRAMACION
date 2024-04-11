package com.borjabolufer.segundotrimestre.tema08.ejercicio08;

import java.util.*;

public class Cipher {
    private long seed;
    private static final String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private Random rnd;

    public Cipher(long seed) {
        this.seed = seed;
    }

    public String cifrar(String texto) {
        rnd = new Random(seed);
        Base64.Encoder encoder = Base64.getEncoder();
        texto = encoder.encodeToString((texto.getBytes()));
        StringBuilder sb = new StringBuilder(texto.length());
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '=') {
                continue;
            }
            int indiceOriginal = abecedario.indexOf(c);
            if (indiceOriginal < 0) {
                System.err.println("ERROR: No se encontró el caracter" + c);
                return null;
            }
            int clave = rnd.nextInt(1, abecedario.length() + 1);
            int nuevoIndice = (indiceOriginal + clave) % abecedario.length();
            char encriptado = abecedario.charAt(nuevoIndice);
            sb.append(encriptado);
        }
        return sb.toString();
    }

    public String descifrar(String textoEncriptado) {
        rnd = new Random(seed);
        StringBuilder textoDescifrado = new StringBuilder(textoEncriptado.length());
        for (int i = 0; i < textoEncriptado.length(); i++) {
            char posicionPass = textoEncriptado.charAt(i);
            int indiceCifrado = abecedario.indexOf(posicionPass);
            int clave = rnd.nextInt(1, abecedario.length() + 1);
            int nuevoIndice = Math.floorMod(indiceCifrado - clave, abecedario.length());
            char descifrado = abecedario.charAt(nuevoIndice);
            textoDescifrado.append(descifrado);
        }
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(textoDescifrado.toString()));
    }

    public String estadisticaPorLetra(String texto) {
        StringBuilder estadisticasBuilder = new StringBuilder();
        int totalLetras = 0;//Variable para almacenar el total de letras en el texto

        // Creamos un array de string para almacenar las ocurrencias de cada letra.
        int[] numOcurrencias = new int[abecedario.length()];
        String[] letras = new String[abecedario.length()];
        // Iteramos sobre cada caracter del texto encriptado.
        for (int i = 0; i < texto.length(); i++) {
            // Obtenemos el caracter en la posición actual del texto encriptado.
            char letra = texto.charAt(i);
            int indice = abecedario.indexOf(letra);
            // Verificamos si la letra está presente en el abecedario.
            if (indice != -1) {
                totalLetras++;
                // Si la letra ya está en el array, incrementamos su frecuencia.
                // Si no está, la agregamos al mapa con una frecuencia inicial de 1.
                numOcurrencias[indice]++;
                letras[indice] = String.valueOf(letra);

            }
        }
        //Convertimos los arrays en cadenas y los agregamos al StringBuilder
        estadisticasBuilder.append("Frecuencia de letras: ");
        for (int i = 0; i < abecedario.length(); i++) {
            if (numOcurrencias[i] > 0) {
                double porcentaje = ((double) numOcurrencias[i] / totalLetras) * 100;
                estadisticasBuilder.append(" \n").append(letras[i]).append(": ").append(numOcurrencias[i]).append(" ").append(String.format("%.2f", porcentaje)).append("%");
            }
        }
        return estadisticasBuilder.toString();
    }
}
