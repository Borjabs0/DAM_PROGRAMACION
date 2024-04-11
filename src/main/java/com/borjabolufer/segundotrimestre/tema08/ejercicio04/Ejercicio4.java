package com.borjabolufer.segundotrimestre.tema08.ejercicio04;

import javax.swing.*;
import java.awt.*;

public class Ejercicio4 {

    public Ejercicio4 (int width, int height) {
        JFrame ventana = new JFrame("Hola Swing");
        ventana.setBounds(740, 250, width, height);



        JPanel panelAficiones = new JPanel();
        panelAficiones.setLayout(new BoxLayout(panelAficiones, BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel("Mis Aficiones:");

        JLabel label2 = new JLabel("Futbol");

        JLabel label3 = new JLabel("Leer");

        JLabel label4 = new JLabel("Cantar");

        JLabel label5 = new JLabel("Bailar");

        JLabel label6 = new JLabel("Coches");

        label1.setForeground(Color.blue);
        label2.setForeground(Color.GRAY);
        label3.setForeground(Color.GRAY);
        label4.setForeground(Color.GRAY);
        label5.setForeground(Color.GRAY);
        label6.setForeground(Color.GRAY);




        panelAficiones.add(label1);
        panelAficiones.add(label2);
        panelAficiones.add(label3);
        panelAficiones.add(label4);
        panelAficiones.add(label5);
        panelAficiones.add(label6);
        ventana.setContentPane(panelAficiones);
        ventana.setVisible(true);

    }

}
