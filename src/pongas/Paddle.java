/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongas;

import java.awt.Graphics;

/**
 *
 * @author Artūras
 */
public interface Paddle {
    
    public void draw(Graphics g);
    public void move();
    public int getY();
    
}
