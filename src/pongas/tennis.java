/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Artūras
 */
public class tennis extends Applet implements Runnable, KeyListener{
    
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIpaddle p2;
    ball b1;
    boolean zaidimopradzia;
    Graphics gfx;
    Image img;
    
    public void init(){
     
        this.resize(WIDTH, HEIGHT);
        zaidimopradzia = false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);     
        b1 = new ball();
        p2 = new AIpaddle(2, b1);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
        
    }
    
    public void paint(Graphics g){
        
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        if(b1.getX() < -10 || b1.getX() > 710){
            
            gfx.setColor(Color.red);
            gfx.drawString("Game Over", 350, 250);
        }
        else{
            p1.draw(gfx);
            b1.Draw(gfx);
            p2.draw(gfx);
        }       
        if(!zaidimopradzia){
            gfx.setColor(Color.white);
            gfx.drawString("Pongas", 340, 100);
            gfx.drawString("Spauskite 'Enter', kad pradeti", 310, 130);
        }
        g.drawImage(img, 0, 0, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void run() {
       
        for(;;){
            
            if(zaidimopradzia){
            p1.move();
            p2.move();
            b1.move();
            b1.checkposition(p1, p2);
            }
            repaint();
            
            try{
                 Thread.sleep(10);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
           
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER){
         zaidimopradzia = true;   
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_UP){
             p1.setUpAccel(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){      
            p1.setDownAccel(false);
        }
    }
    
    
}
