package com.borjabolufer.segundotrimestre.tema08.calculadoraUI;

import com.borjabolufer.segundotrimestre.tema08.calculadora.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraController {
    private Calculadora calculadora;
    private final ActionListener actionDigito;
//    private final ActionListener actionPunto;
//    private final ActionListener actionOperador;
//    private final ActionListener actionIgual;
//    private final ActionListener actionON;
//    private final ActionListener actionOFF;
//    private final ActionListener actionAC;
    public CalculadoraController() {
        calculadora = new Calculadora();
        actionDigito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton boton = (JButton) e.getSource();
//                    calculadora.addDigito(boton.getText());
                }
            }
        };

    }
}
