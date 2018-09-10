package com.killthewookiee.snake.entities;

import java.awt.*;

public class BodyPart {

    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor, int yCoor, int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }


    public void tick(){


    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(xCoor * width, yCoor * height, width-2, height-2);

    }
}
