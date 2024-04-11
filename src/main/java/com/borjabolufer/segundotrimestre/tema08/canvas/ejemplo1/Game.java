package com.borjabolufer.segundotrimestre.tema08.canvas.ejemplo1;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements  Runnable{
    private final int widht;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;
    //private final Ball ball;
    private final GameOfLife gameOfLife;

    public Game(int width, int height, float fpsLimit){
        this.widht = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setFocusable(true);
        //ball = new Ball(10, 10, 30, 10, Color.WHITE, width, height);

        gameOfLife = new GameOfLife(width, height, 10);
    }


    /**
     * Metodo para iniciar el hilo
     */
    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override // Sirve para asegurar que realmente estamos implementando el metodo run y no  otro
    /**
     * Metodo el cual
     */
    public void run() {
        final double NANOS_BETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame; //Frame actual
        long lastFrame = currentFrame = System.nanoTime(); //Anterior frame

        System.out.println("Iniciando Juego...");
        while (!finished){
            currentFrame = System.nanoTime();
            // TODO: SACAR METODOS UPDATE Y PROCESSINPUT FUERA DEL IF
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) {// Ha pasado la 1/fpsLimit segundos
                processInput();
                update();
                draw();
                lastFrame = currentFrame;
            }
        }
    }



    private void draw() {
        repaint();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D  g2 = (Graphics2D) g;
        g.setColor(Color.WHITE);
        gameOfLife.draw(g2);
    }

    private void update() {
        //TODO: update
        //personaje.x = personaje.x + velocidad;
        gameOfLife.update();
    }

    private void processInput() {
        //TODO: processInput
    }
}
