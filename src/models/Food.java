/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import utils.GraphicsChart;


/**
 *
 * @author sombiniaina
 */
public abstract class Food extends GraphicsChart{
    public Food(){
        super(0, 0, 10, 10);
    }
    
    public int getLengthBrings(){
        return 1;
    }
    
    public void changePosition(Dimension dimension){
        Random random = new Random();
        int x = random.nextInt(dimension.width);
        int y = random.nextInt(dimension.height);
        this.setLocation(x - x%10, y - y%10);
    }
    
    public String toString(){
        return String.format("[x:%s, y:%s]", this.x, this.y);
    }
    
    public abstract void draw(Graphics g);
}
