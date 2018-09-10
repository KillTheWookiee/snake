package com.killthewookiee.snake.entities;

import java.awt.*;

public class Apple {
    private int posX, posY;

    public Apple(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(posX * 10, posY * 10, 10,10);
    }
}
