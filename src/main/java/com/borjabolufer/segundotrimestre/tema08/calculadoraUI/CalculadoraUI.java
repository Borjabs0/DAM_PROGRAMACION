package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraUI {


    public CalculadoraUI(int width, int height) {
        String[][] textButtons = {
                {"ON", "OFF", "%", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"0", ".", "AC", "="},
        };
        //Ventana
        JButton[] buttons = new JButton[textButtons.length * textButtons[0].length];
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
        for (int i = 0; i < textButtons.length; i++) { // Bucle el qual va a recorrer las filas de la matriz
            for (int j = 0; j < textButtons[i].length; j++) {// Bucle el qual va a recorrer las columnas de la matriz
                JButton boton = new JButton("" + textButtons[i][j]);// Creacion de un nuevo objeto = boton el qual le pasaremos las filas y columnas de la matriz
                buttons[i * textButtons[0].length + j] = boton;//
                boton.addActionListener(actionListener);
                panelBotones.add(boton);// Agrega el boton creado al panelBotones
            }
        }
        panelPrincipal.add(panelCalculadora);
        panelPrincipal.add(panelBotones);
        ventana1.setContentPane(panelPrincipal);
        ventana1.pack();
        ventana1.setVisible(true);


    }
}


