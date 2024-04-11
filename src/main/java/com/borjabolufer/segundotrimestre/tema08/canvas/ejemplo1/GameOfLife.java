package com.borjabolufer.segundotrimestre.tema08.canvas.ejemplo1;

import java.awt.*;

public class GameOfLife {
    private final int width;
    private final int height;
    private final int cellSize;//Tamaño de las celdas
    // matrix of cells
    private int[][] world;
    private int[][] nextWorld;


    public GameOfLife(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        world = new int[height][width];
        nextWorld = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void update(){
        // Simular una generación
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        //For para dibujar las lineas horizontales del tablero
        for (int i = 0; i < height; i += cellSize) {
            g2.drawLine(0, i, width, i);
        }
        //For para dibujar las lineas verticales del tablero
        for (int i = 0; i < width; i += cellSize) {
            g2.drawLine(i, 0, i, height);
        }
    }
    }
