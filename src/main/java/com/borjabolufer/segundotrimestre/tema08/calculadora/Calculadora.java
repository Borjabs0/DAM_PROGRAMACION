package com.borjabolufer.segundotrimestre.tema08.calculadora;

import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {
        int width = 1200;
        int height = 400;
        JFrame ventana1 = new JFrame("Hola GUI");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2) - width / 2;
        long y = Math.round(dimension.getHeight() / 2) - height / 2;

        String[] simbolosUno = new String[]
                {"", "CE", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", "", "",   "="};
        JPanel panelCalculadora = new JPanel();
        GridLayout gridLayoutCalculadora = new GridLayout(5, 4);
        panelCalculadora.setLayout(gridLayoutCalculadora);
        for (int i = 0; i < simbolosUno.length; i++) {
            JButton button = new JButton(simbolosUno[i]);
            panelCalculadora.add(button);
        }

        ventana1.setContentPane(panelCalculadora);
        ventana1.setResizable(true);
        ventana1.pack();
        ventana1.setVisible(true);

    }
}
