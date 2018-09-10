package com.killthewookiee.snake.graphics;


import com.killthewookiee.snake.entities.Apple;
import com.killthewookiee.snake.entities.BodyPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements Runnable{
    private static final int WIDTH = 500, HEIGHT = 500;
    private boolean running = false;
    private ArrayList<BodyPart> snake;
    private Random generator = new Random();
    private Apple apple;


    private boolean isAppleOnMap = false, isPaused = false;
    private int xCoor = 10, yCoor = 10, posX, posY;


    private boolean goRight = true, goDown = false, goUp = false, goLeft = false;
    private int size = 1;


    public Screen(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        snake = new ArrayList<>();



        setFocusable(true);
        Key key = new Key();
        addKeyListener(key);
    }


    private void newApple(){

        posX = generator.nextInt(49) + 1;
        posY = generator.nextInt(49) + 1;

        apple = new Apple(posX, posY);
        isAppleOnMap = true;


    }

    private void tick(){
        BodyPart b;
        if(snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);

        }
            if (goRight) xCoor++;
            if (goLeft) xCoor--;
            if (goUp) yCoor--;
            if (goDown) yCoor++;

            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);

        if(snake.size() > size){
            snake.remove(0);
        }

        detectCollision();
        if(!isAppleOnMap){
            newApple();
        }
    }


    public void start(){
        running = true;
        Thread thread = new Thread(this, "Game Loop");
        thread.start();

    }
    public void paint(Graphics g) {
        g.clearRect(0,0,WIDTH,HEIGHT);
        g.fillRect(0,0,WIDTH,HEIGHT);
       /*  just for testing

       for (int i = 0; i < WIDTH; i++) {
            if (i % 10 == 0) {
                g.setColor(Color.WHITE);
                g.drawLine(WIDTH, i, 0, i);
                g.drawLine(i, 0, i, HEIGHT);
            }

        }*/
       apple.draw(g);

        for (BodyPart aSnake : snake) aSnake.draw(g);

    }
    public void stop(){
        running = false;


    }
    public void run(){
        while(running){
            tick();
            repaint();

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void detectCollision(){
        if(xCoor == posX && yCoor == posY){
            isAppleOnMap = false;
            size++;

        }

    }

private class Key implements KeyListener{



    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            goRight = false; goDown = true; goUp = false; goLeft = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            goRight = false; goDown = false; goUp = true; goLeft = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            goRight = false; goDown = false; goUp = false; goLeft = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            goRight = true; goDown = false; goUp = false; goLeft = false;
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}

}
