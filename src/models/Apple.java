/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sombiniaina
 */
public class Apple extends Food{
    public Apple(){
        super();
        this.setColor(Color.decode("#eb3434"));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
    
}
