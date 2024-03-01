package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraUI {



    public CalculadoraUI(int width, int height) {

        Boton[][] textoBotones = {
                {new Boton("ON", Boton.Accion.ON), new Boton("OFF", Boton.Accion.OFF),  new Boton("%", Boton.Accion.OPERADOR ),  new Boton("/", Boton.Accion.OPERADOR)},
                {new Boton("7", Boton.Accion.DIGITO),  new Boton("8", Boton.Accion.DIGITO),new Boton("9", Boton.Accion.DIGITO) , new Boton("*", Boton.Accion.OPERADOR)},
                {new Boton("5", Boton.Accion.DIGITO),  new Boton("6", Boton.Accion.DIGITO),new Boton("7", Boton.Accion.DIGITO) , new Boton("-", Boton.Accion.OPERADOR)},
                {new Boton("1", Boton.Accion.DIGITO),  new Boton("2", Boton.Accion.DIGITO),new Boton("3", Boton.Accion.DIGITO) , new Boton("+", Boton.Accion.OPERADOR)},
                {new Boton("0", Boton.Accion.DIGITO),  new Boton(".", Boton.Accion.DIGITO),new Boton("AC", Boton.Accion.DIGITO) , new Boton("=", Boton.Accion.OPERADOR)},

        };


        //Ventana
        JButton[] buttons = new JButton[textoBotones.length * textoBotones[0].length];
        JFrame ventana1 = new JFrame("CALCULADORA");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2) - width / 2;
        long y = Math.round(dimension.getHeight() / 2) - height / 2;

        //Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        //Panel display Calculadora
        JPanel panelCalculadora = new JPanel();
        GridLayout gridLayoutCalculadora = new GridLayout(5, 4);
        panelCalculadora.setLayout(gridLayoutCalculadora);
        JLabel labelCalculadora = new JLabel("Introduce un numero");
        panelCalculadora.add(labelCalculadora);
        panelCalculadora.setBackground(Color.GREEN);

        //Panel botones
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se a pulsado el boton");
            }
        };
        JPanel panelBotones = new JPanel();
        GridLayout gridLayoutBoton = new GridLayout(5, 4);
        panelBotones.setLayout(gridLayoutBoton);
        for (int i = 0; i < textoBotones.length; i++) { // Bucle el qual va a recorrer las filas de la matriz
            for (int j = 0; j < textoBotones[i].length; j++) {// Bucle el qual va a recorrer las columnas de la matriz
                JButton boton = new JButton("" + textoBotones[i][j]);// Creacion de un nuevo objeto = boton el qual le pasaremos las filas y columnas de la matriz
                buttons[i * textoBotones[0].length + j] = boton;//
                boton.addActionListener(actionListener);
                panelBotones.add(boton);// Agrega el boton creado al panelBotones
            }
        }
        panelPrincipal.add(panelCalculadora);
        panelPrincipal.add(panelBotones);
        ventana1.setContentPane(panelPrincipal);
        ventana1.setBounds((int)x, (int)y, width, height);
        ventana1.pack();
        ventana1.setVisible(true);


    }
}


