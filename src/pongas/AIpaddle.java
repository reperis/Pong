/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongas;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Artūras
 */
public class AIpaddle implements Paddle{

    double y, yVel;
    boolean upAccel, downAccel;
    int player, x;
    final double GRAVITY = 0.5;
    ball b1;
    
    public AIpaddle(int player, ball b){
        
        upAccel = false; downAccel = false;
        b1 = b;
        y = 210; yVel = 0;
        
        if(player == 1)
            x = 20;
        else
            x = 660;
        
    }
        
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, (int)y, 20, 80);
    }

    @Override
    public void move() {
        
        y = b1.getY() - 40;
        
        if(y < 0){
            y = 0;
        }
       if (y > 420){
            y = 420;
        }
        
    }
       
    @Override
    public int getY() {
        return (int)y;
    }
    
}
