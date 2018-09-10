package com.killthewookiee.snake.graphics;

import java.awt.*;

public class PauseScreen {

    public void open(Graphics g){
        g.drawString("GAME PAUSED", 200,200);
        g.drawRect(0,0,500,500);

    }
}
