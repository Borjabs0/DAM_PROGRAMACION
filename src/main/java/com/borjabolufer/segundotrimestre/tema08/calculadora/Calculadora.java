package com.borjabolufer.segundotrimestre.tema08.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        String[] simbolosUno = new String[]
                {"C", "CE", "%", "/",
                        "7", "8", "9", "*",
                        "4", "5", "6", "-",
                        "1", "2", "3", "+",
                        "+/-", "0", ",",   "="};

        JFrame ventana1 = new JFrame("CALCULADORA");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2) - width / 2;
        long y = Math.round(dimension.getHeight() / 2) - height / 2;




        JPanel panelCalculadora = new JPanel();
        GridLayout gridLayoutCalculadora = new GridLayout(5, 4);
        panelCalculadora.setLayout(gridLayoutCalculadora);

        for (int i = 0; i < simbolosUno.length; i++) {
            JButton button = new JButton(simbolosUno[i]);
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            panelCalculadora.add(button);
        }
        ventana1.setContentPane(panelCalculadora);
        ventana1.setBounds((int)x, (int)y, width, height);
        ventana1.pack();
        ventana1.setVisible(true);

    }
}
