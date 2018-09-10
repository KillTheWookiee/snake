package com.killthewookiee.snake;

import com.killthewookiee.snake.graphics.Screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {


    private Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake game");
        setResizable(false);

        init();

    }


    private void init(){
        setLayout(new GridLayout(1,1,0,0));

        Screen s = new Screen();
        add(s);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        s.start();

    }


    public static void main(String[] args) {

        new Frame();
    }
}
