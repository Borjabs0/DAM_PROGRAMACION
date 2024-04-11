package com.borjabolufer;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import com.borjabolufer.Lib.LibIO;
import com.borjabolufer.Lib.LibUI;
import com.borjabolufer.segundotrimestre.tema08.canvas.ejemplo1.Game;
import com.borjabolufer.segundotrimestre.tema08.ejercicio08.CipherBase64;
import com.borjabolufer.segundotrimestre.tema08.ejercicio08.Cipher;
import com.borjabolufer.utils.Lib;

import javax.swing.*;

public class Main {
    //private static Date fecha = new Date();
    private  static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Ejercicio7 ejercicio7 = new Ejercicio7();
//        String texto;
//        System.out.println("Introduce el texto a cifrar");
//        texto = scanner.nextLine();
//        Cipher modelo = new Cipher(27);
//        String textoCifrado = modelo.cifrar(texto);
//        System.out.println(textoCifrado);
//        System.out.println(modelo.descifrar(textoCifrado));
//
//
//        CipherBase64 cipherBase64 = new CipherBase64();
//        String textoCifradoBase64 = cipherBase64.encode(texto);
//        String textoDesconprimir = cipherBase64.decode(textoCifradoBase64);
//
//        System.out.println();
//        System.out.println("Cifrado en base 64 ");
//        System.out.println("Texto encriptado: " + textoCifradoBase64);
//        System.out.println("Texto descifrado: " + textoDesconprimir);
//
//        System.out.println("Ocurrencias de las letras");
//        System.out.println(modelo.estadisticaPorLetra(texto));


        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Game Of Life");


        Game game = new Game(1280, 960, 60);
        frame.add(game);
        frame.pack();
        LibUI.setMonitor(frame, 2);
        frame.setVisible(true);
        game.start();
    }
}