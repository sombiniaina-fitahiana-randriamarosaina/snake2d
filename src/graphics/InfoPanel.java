/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import models.Game;

/**
 *
 * @author sombiniaina
 */
public class InfoPanel extends JPanel{
    public InfoPanel(Game game){
        this.game = game;
        this.setPreferredSize(new Dimension(400, 20));
    }
    
    // Fields
    protected Game game;
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, this.getSize().width, this.getSize().height);
        g.setColor(Color.decode("#bdbdbd"));
        String info = String.format("Score : %s   Best : %s", this.game.getPlayer().getScore(), this.game.getPlayer().getBestScore()); 
        g.drawString(info, 10, this.getHeight() - 5);
    }
}
