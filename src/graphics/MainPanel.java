/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import models.Game;

/**
 *
 * @author sombiniaina
 */
public class MainPanel extends JPanel{
    public MainPanel(Game game){
        this.setName("MainPanel");
        this.setPreferredSize(new Dimension(400, 400));
        this.game = game;
    }
    
    // Fields
    protected Game game;
    
    public void paintGameOver(Graphics g){
        g.setColor(Color.decode("#bdbdbd"));
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Game Over", 45, this.getHeight()/2);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Press 'r' to restart", 130, this.getHeight()/2 + 30);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, this.getSize().width, this.getSize().height);
        g.setColor(Color.decode("#060606"));
        for (int j = 0; j < this.getHeight(); j += 10) {
            for(int i = 0 ; i < this.getWidth(); i += 20){
                g.fillRect(((j%20 == 0) ? i : i + 10), j, 10, 10);
            }
        }
        
        this.game.getFood().draw(g);
        this.game.getPlayer().getSnake().draw(g);
        if(this.game.isGameOver())
            this.paintGameOver(g);
    }
}
 