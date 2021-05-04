/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author sombiniaina
 */
public class GraphicsChart extends Rectangle{
    public GraphicsChart(int x, int y, int width, int height){
        super (x, y, width, height);
    }
    
    public GraphicsChart(Point p, Dimension dim){
        super (p, dim);
    }
    
    // Fields
    protected Color color = Color.WHITE;
    
    // Getters & Setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
