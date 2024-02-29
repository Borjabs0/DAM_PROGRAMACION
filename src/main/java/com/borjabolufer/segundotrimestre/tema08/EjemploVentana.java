package com.borjabolufer.segundotrimestre.tema08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploVentana {
    public static void  main(String[] args){
        int widht = 400;
        int height = 400;
        JFrame ventana1 = new JFrame("Hola GUI");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2) - widht / 2;
        long y  = Math.round(dimension.getHeight() / 2) - height / 2;
        JLabel label1 = new JLabel("Hola GUI Hola GUI Hola GUI Hola GUI");
        JLabel label2 = new JLabel("Hola GUI Hola GUI Hola GUI Hola GUI");
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,5);
        panel.setLayout(gridLayout);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón ");
            }
        };
        for (int i = 10; i >= 0; i--) {
            JButton button = new JButton("" + i);
            button.addActionListener(actionListener);
            panel.add(button);
        }
       /* for (int i = 10; i >= 0; i--) {
            JButton button = new JButton("" + i);
            button.addActionListener(actionListener);
            panel.add(button);
        }*/
        ventana1.setContentPane(panel);
        ventana1.setBounds((int)x, (int)y, widht, height);
        ventana1.setResizable(true);
        ventana1.pack();
        ventana1.setVisible(true);

        /*int opcion = JOptionPane.showConfirmDialog(ventana1, "¿Seguro que quiere salir?");
        System.out.print(opcion);
*/
    }
}
